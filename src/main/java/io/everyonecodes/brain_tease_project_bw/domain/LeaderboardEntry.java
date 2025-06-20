package io.everyonecodes.brain_tease_project_bw.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaderboardEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String playerName;
    private int score;
    private LocalDate achievedAt;

    @Enumerated(EnumType.STRING)
    private GameMode gameMode;
}
