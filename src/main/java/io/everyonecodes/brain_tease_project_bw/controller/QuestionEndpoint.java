package io.everyonecodes.brain_tease_project_bw.controller;

import io.everyonecodes.brain_tease_project_bw.domain.Question;
import io.everyonecodes.brain_tease_project_bw.logic.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionEndpoint {

    private final QuestionService questionService;

    public QuestionEndpoint(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/random")
    public Question getRandomQuestion() {
        return questionService.getRandomQuestion()
                .orElseThrow(() -> new IllegalStateException("No questions found"));
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @PostMapping
    public Question addQuestion(@RequestBody Question question) {
        return questionService.saveQuestion(question);
    }
}
