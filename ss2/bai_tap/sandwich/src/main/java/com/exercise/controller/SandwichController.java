package com.exercise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String chooseSandwich() {
        return "list";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String save(@RequestParam("condiment") String[] condiment, Model model) {
        model.addAttribute("condiment", condiment);
        return "result";
    }
}
