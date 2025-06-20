package io.everyonecodes.brain_tease_project_bw.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;             // e.g. "3 + 4 = ?"
    private String correctAnswer;       // e.g. "7"

    private String imageUrl;            // optional, e.g. "/images/puzzle1.png" or a full URL
}
