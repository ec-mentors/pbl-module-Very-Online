package io.everyonecodes.brain_tease_project_bw.controller.view;

import io.everyonecodes.brain_tease_project_bw.domain.GameMode;
import io.everyonecodes.brain_tease_project_bw.domain.Question;
import io.everyonecodes.brain_tease_project_bw.logic.LeaderboardService; // Not needed in this controller anymore if saving moves
import io.everyonecodes.brain_tease_project_bw.logic.QuestionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/mode-selection/normal-gameplay")
public class GameController {

    private final QuestionService questionService;

    public GameController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public String showNormalGame(HttpSession session, Model model) {

        Integer score = (Integer) session.getAttribute("score");
        Integer lives = (Integer) session.getAttribute("lives");
        Set<Long> answeredQuestionIds = (Set<Long>) session.getAttribute("answeredQuestionIds");

        if (score == null || lives == null || answeredQuestionIds == null) {
            score = 0;
            lives = 3;
            answeredQuestionIds = new HashSet<>();
            session.setAttribute("score", score);
            session.setAttribute("lives", lives);
            session.setAttribute("answeredQuestionIds", answeredQuestionIds);
        }

        if (lives <= 0) {
            Integer finalScore = (Integer) session.getAttribute("score");
            session.removeAttribute("score");
            session.removeAttribute("lives");
            session.removeAttribute("answeredQuestionIds");

            return "redirect:/game-over?finalScore="
                    + finalScore
                    + "&title=Game Over!&subtitle=You ran out of lives.&status=failure";
        }

        Optional<Question> oQuestion = questionService.getRandomQuestionExcludingIds(answeredQuestionIds);

        if (oQuestion.isEmpty()) {
            Integer finalScore = (Integer) session.getAttribute("score");
            session.removeAttribute("score");
            session.removeAttribute("lives");
            session.removeAttribute("answeredQuestionIds");

            return "redirect:/game-over?finalScore="
                    + finalScore
                    + "&title=Congratulations!&subtitle=You answered all the questions!&status=success";
        }

        String livesDisplay = String.join("", Collections.nCopies(lives, "❤️"));
        model.addAttribute("score", score);
        model.addAttribute("livesDisplay", livesDisplay);
        model.addAttribute("question", oQuestion.get());

        return "normal-gameplay";
    }

    @PostMapping("/submit")
    public String handleSubmit(@RequestParam Long questionId, @RequestParam String userAnswer, HttpSession session) {

        Integer score = (Integer) session.getAttribute("score");
        Integer lives = (Integer) session.getAttribute("lives");
        Set<Long> answeredQuestionIds = (Set<Long>) session.getAttribute("answeredQuestionIds");

        if (score == null || lives == null || answeredQuestionIds == null) {
            return "redirect:/mode-selection/normal-gameplay";
        }

        Optional<Question> oQuestion = questionService.getQuestionById(questionId);
        if (oQuestion.isPresent()) {
            Question question = oQuestion.get();
            if (question.getCorrectAnswer().equalsIgnoreCase(userAnswer.trim())) {
                session.setAttribute("score", score + 100);
            } else {
                session.setAttribute("lives", lives - 1);
            }
            answeredQuestionIds.add(questionId);
            session.setAttribute("answeredQuestionIds", answeredQuestionIds);
        }

        return "redirect:/mode-selection/normal-gameplay";
    }

    @GetMapping("/exit")
    public String exitGameAndResetSession(HttpSession session) {

        session.removeAttribute("score");
        session.removeAttribute("lives");
        session.removeAttribute("answeredQuestionIds");

        return "redirect:/mode-selection";
    }
}