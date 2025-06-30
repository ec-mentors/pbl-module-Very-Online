package io.everyonecodes.brain_tease_project_bw.controller;

import io.everyonecodes.brain_tease_project_bw.domain.GameMode;
import io.everyonecodes.brain_tease_project_bw.domain.LeaderboardEntry;
import io.everyonecodes.brain_tease_project_bw.logic.LeaderboardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaderboard")
public class LeaderboardController {

    private final LeaderboardService leaderboardService;

    public LeaderboardController(LeaderboardService leaderboardService) {
        this.leaderboardService = leaderboardService;
    }

    @PostMapping
    public LeaderboardEntry addLeaderboardEntry(@RequestBody LeaderboardEntry leaderboardEntry) {
        return leaderboardService.saveLeaderboardEntry(leaderboardEntry);
    }

    @GetMapping("/{gameModeString}")
    public List<LeaderboardEntry> getLeaderboardByGameMode(@PathVariable String gameModeString) {
        try {
            GameMode gameMode = GameMode.valueOf(gameModeString.toUpperCase());
            return leaderboardService.getTop5LeaderboardEntries(gameMode);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid game mode: " + gameModeString + ". Valid modes are NORMAL and SPEED");
        }
    }

    @GetMapping
    public List<LeaderboardEntry> getAllLeaderboardEntries() {
        return leaderboardService.getAllLeaderboardEntries();
    }
}
