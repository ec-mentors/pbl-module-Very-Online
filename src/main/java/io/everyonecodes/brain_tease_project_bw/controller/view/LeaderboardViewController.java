package io.everyonecodes.brain_tease_project_bw.controller.view;

import io.everyonecodes.brain_tease_project_bw.domain.GameMode;
import io.everyonecodes.brain_tease_project_bw.domain.LeaderboardEntry;
import io.everyonecodes.brain_tease_project_bw.logic.LeaderboardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/highscores")
public class LeaderboardViewController {

    private final LeaderboardService leaderboardService;

    public LeaderboardViewController(LeaderboardService leaderboardService) {
        this.leaderboardService = leaderboardService;
    }

    @GetMapping
    public String viewHighscores() {
        return "highscores";
    }

    @GetMapping("/{gameModeString}")
    public String viewLeaderboardByGameMode(@PathVariable String gameModeString, Model model) {
        try {
            GameMode gameMode = GameMode.valueOf(gameModeString.toUpperCase());
            List<LeaderboardEntry> entries = leaderboardService.getTop5LeaderboardEntries(gameMode);
            model.addAttribute("entries", entries);

            if (gameMode == GameMode.NORMAL) {
                return "normal-leaderboard";
            } else if (gameMode == GameMode.SPEED) {
                return "speed-leaderboard";
            } else {
                return "redirect:/highscores";
            }
        } catch (IllegalArgumentException e) {
            return "redirect:/highscores";
        }
    }
}
