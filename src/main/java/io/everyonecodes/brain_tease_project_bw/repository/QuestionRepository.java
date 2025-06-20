package io.everyonecodes.brain_tease_project_bw.repository;

import io.everyonecodes.brain_tease_project_bw.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
