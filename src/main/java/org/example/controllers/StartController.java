package org.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class StartController {

    @GetMapping("/api/home")
    public Map<String, String> start() {
        return Map.of("message", "Hello, you are on the homepage!");
    }

}
