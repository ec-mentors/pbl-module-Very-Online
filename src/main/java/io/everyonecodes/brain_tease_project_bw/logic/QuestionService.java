package io.everyonecodes.brain_tease_project_bw.logic;

import io.everyonecodes.brain_tease_project_bw.domain.Question;
import io.everyonecodes.brain_tease_project_bw.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set; // Import Set

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Optional<Question> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    public void deleteQuestionById(Long id) {
        questionRepository.deleteById(id);
    }

    public Optional<Question> getRandomQuestion() {
        List<Question> questions = getAllQuestions();
        if (questions.isEmpty()) {
            return Optional.empty();
        }
        Collections.shuffle(questions);
        return Optional.of(questions.get(0));
    }

    public Optional<Question> getRandomQuestionExcludingIds(Set<Long> excludedQuestionIds) {
        List<Question> allQuestions = questionRepository.findAll();

        List<Question> availableQuestions = allQuestions.stream()
                .filter(question -> !excludedQuestionIds.contains(question.getId()))
                .collect(java.util.stream.Collectors.toList());

        if (availableQuestions.isEmpty()) {
            return Optional.empty();
        }

        Collections.shuffle(availableQuestions);
        return Optional.of(availableQuestions.get(0));
    }
}
