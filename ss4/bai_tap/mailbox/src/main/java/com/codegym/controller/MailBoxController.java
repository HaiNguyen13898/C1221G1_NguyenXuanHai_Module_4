package com.codegym.controller;

import com.codegym.model.Mail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class MailBoxController {

    @PostMapping("/create")
    public String showForm(@ModelAttribute Mail mail, Model model) {
        model.addAttribute("mail", mail);
        return "display";
    }


    @GetMapping("/create")
    public String createNewMailBox(Model model) {
        model.addAttribute("mail", new Mail());
        model.addAttribute("languages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("pageSizes", new String[]{"5", "10", "15", "25", "50", "100"});
        return "create";
    }


}
