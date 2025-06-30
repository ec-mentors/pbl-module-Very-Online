package io.everyonecodes.brain_tease_project_bw.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;             // e.g. "3 + 4 = ?"a
    private String correctAnswer;       // e.g. "7"

    private String imageUrl;            // optional, e.g. "/images/puzzle1.png" or a full URL
}
