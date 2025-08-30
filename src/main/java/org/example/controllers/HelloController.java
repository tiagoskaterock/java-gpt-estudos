package org.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping(value = "/api/hello", produces = "application/json")
    public Map<String, String> hello() {
        return Map.of("message", "Hello Spring Boot!");
    }

}
