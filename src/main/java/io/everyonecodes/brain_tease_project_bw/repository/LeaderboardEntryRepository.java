package io.everyonecodes.brain_tease_project_bw.repository;

import io.everyonecodes.brain_tease_project_bw.domain.GameMode;
import io.everyonecodes.brain_tease_project_bw.domain.LeaderboardEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaderboardEntryRepository extends JpaRepository<LeaderboardEntry, Long> {
    List<LeaderboardEntry> findTop5ByGameModeOrderByScoreDesc(GameMode gameMode);
}
