package io.everyonecodes.brain_tease_project_bw.logic;

import io.everyonecodes.brain_tease_project_bw.domain.GameMode;
import io.everyonecodes.brain_tease_project_bw.domain.LeaderboardEntry;
import io.everyonecodes.brain_tease_project_bw.repository.LeaderboardEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderboardService {

    private final LeaderboardEntryRepository leaderboardEntryRepository;

    public LeaderboardService(LeaderboardEntryRepository leaderboardEntryRepository) {
        this.leaderboardEntryRepository = leaderboardEntryRepository;
    }

    public LeaderboardEntry saveLeaderboardEntry(LeaderboardEntry leaderboardEntry) {
        return leaderboardEntryRepository.save(leaderboardEntry);
    }

    public List<LeaderboardEntry> getTop5LeaderboardEntries(GameMode gameMode) {
        return leaderboardEntryRepository.findTop5ByGameModeOrderByScoreDesc(gameMode);
    }

    public List<LeaderboardEntry> getAllLeaderboardEntries() {
        return leaderboardEntryRepository.findAll();
    }

    public boolean isHighscore(int score, GameMode gameMode) {
        List<LeaderboardEntry> top5 = leaderboardEntryRepository.findTop5ByGameModeOrderByScoreDesc(gameMode);
        if (top5.isEmpty()) {
            return false;
        }
        if (top5.size() < 5) {
            return true;
        }
        int lowestTopScore = top5.get(top5.size() - 1).getScore();
        return score > lowestTopScore;
    }
}
