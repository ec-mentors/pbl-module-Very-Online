package io.everyonecodes.brain_tease_project_bw.domain;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FillInTheBlankQuestion extends Question {

    private String correctAnswer;
    private String imageUrl;
}
