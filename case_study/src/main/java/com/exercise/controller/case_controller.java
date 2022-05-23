package com.exercise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class case_controller {
    @GetMapping
    public String home () {
        return "/home_page";
    }
}
