package io.everyonecodes.brain_tease_project_bw.controller.api; // Recommend putting API controllers in a separate package

import io.everyonecodes.brain_tease_project_bw.domain.GameMode;
import io.everyonecodes.brain_tease_project_bw.domain.LeaderboardEntry;
import io.everyonecodes.brain_tease_project_bw.logic.LeaderboardService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller; // Keep Controller if you return String
import org.springframework.web.servlet.view.RedirectView; // For redirecting after POST

import java.time.LocalDate;

@Controller // Use @Controller for returning view names/redirects
@RequestMapping("/leaderboard") // Base path for leaderboard actions
public class LeaderboardAPIController { // Renamed from LeaderboardController

    private final LeaderboardService leaderboardService;

    public LeaderboardAPIController(LeaderboardService leaderboardService) {
        this.leaderboardService = leaderboardService;
    }

    @PostMapping("/save")
    public RedirectView saveLeaderboardEntry(
            @RequestParam String playerName,
            @RequestParam int score,
            @RequestParam String gameMode) { // Expect gameMode as a String

        // Convert gameMode string to Enum
        GameMode mode = GameMode.valueOf(gameMode.toUpperCase());

        LeaderboardEntry newEntry = new LeaderboardEntry(null, playerName, score, LocalDate.now(), mode);
        leaderboardService.saveLeaderboardEntry(newEntry);

        // Redirect to the appropriate leaderboard view after saving
        return new RedirectView("/highscores/" + gameMode.toLowerCase());
    }
}