package org.example.gym.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String home() {
        return "¡El backend del Gimnasio está ejecutándose correctamente!";
    }
}