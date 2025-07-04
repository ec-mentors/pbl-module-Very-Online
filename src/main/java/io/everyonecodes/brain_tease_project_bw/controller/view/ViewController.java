package io.everyonecodes.brain_tease_project_bw.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ViewController {

    @GetMapping
    public String viewHome() {
        return "index";
    }

    @GetMapping("/mode-selection")
    public String viewModes() {
        return "mode-selection";
    }

    @GetMapping("/settings")
    public String viewSettings() {
        return "settings";
    }

    @GetMapping("/game-over")
    public String showGameOverPage(
            @RequestParam("title") String title,
            @RequestParam("subtitle") String subtitle,
            @RequestParam("finalScore") int finalScore,
            @RequestParam("status") String status,
            Model model) {

        model.addAttribute("title", title);
        model.addAttribute("subtitle", subtitle);
        model.addAttribute("finalScore", finalScore);
        model.addAttribute("status", status);

        return "game-over";
    }
}