package io.everyonecodes.brain_tease_project_bw.controller.api;

import io.everyonecodes.brain_tease_project_bw.domain.GameMode;
import io.everyonecodes.brain_tease_project_bw.domain.LeaderboardEntry;
import io.everyonecodes.brain_tease_project_bw.logic.LeaderboardService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;

@Controller
@RequestMapping("/leaderboard")
public class LeaderboardAPIController {

    private final LeaderboardService leaderboardService;

    public LeaderboardAPIController(LeaderboardService leaderboardService) {
        this.leaderboardService = leaderboardService;
    }

    @PostMapping("/save")
    public RedirectView saveLeaderboardEntry(

            @RequestParam String playerName,
            @RequestParam int score,
            @RequestParam String gameMode) {

        GameMode mode = GameMode.valueOf(gameMode.toUpperCase());

        LeaderboardEntry newEntry = new LeaderboardEntry(null, playerName, score, LocalDate.now(), mode);
        leaderboardService.saveLeaderboardEntry(newEntry);

        return new RedirectView("/highscores/" + gameMode.toLowerCase());
    }
}