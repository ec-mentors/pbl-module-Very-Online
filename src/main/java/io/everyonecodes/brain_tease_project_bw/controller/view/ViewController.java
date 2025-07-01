package io.everyonecodes.brain_tease_project_bw.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ViewController {

    @GetMapping
    public String viewHome() {
        return "index"; // Returns templates/index.html
    }

    @GetMapping("/challenges")
    public String viewChallenges() {
        return "challenges"; // Returns templates/challenges.html
    }

    @GetMapping("/settings")
    public String viewSettings() {
        return "settings"; // Returns templates/settings.html
    }
}