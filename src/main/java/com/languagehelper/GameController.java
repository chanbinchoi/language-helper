package com.languagehelper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/game/vowel")
    public String vowelGame() {
        return "vowel-game";
    }
}
