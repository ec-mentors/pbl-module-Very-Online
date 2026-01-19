package io.everyonecodes.brain_tease_project_bw.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MultipleChoiceQuestion extends Question {

    @ElementCollection
    private List<String> options;

    private String correctAnswer;
}
