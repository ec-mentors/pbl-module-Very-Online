package io.everyonecodes.brain_tease_project_bw.controller.api;

import io.everyonecodes.brain_tease_project_bw.domain.FillInTheBlankQuestion;
import io.everyonecodes.brain_tease_project_bw.domain.MultipleChoiceQuestion;
import io.everyonecodes.brain_tease_project_bw.repository.QuestionRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/questions")
public class QuestionAPIController {

    private final QuestionRepository questionRepository;

    public QuestionAPIController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @PostMapping("/fill")
    public FillInTheBlankQuestion addFillQuestion(@RequestBody FillInTheBlankQuestion question) {
        return questionRepository.save(question);
    }

    @PostMapping("/mcq")
    public MultipleChoiceQuestion addMcqQuestion(@RequestBody MultipleChoiceQuestion question) {
        return questionRepository.save(question);
    }
}
