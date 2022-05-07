package com.exercise.controller;

import com.exercise.model.HealthDeclaration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HealthDeclarationController {

    @GetMapping("")
    public String showForm(Model model) {
        model.addAttribute("form", new HealthDeclaration());
        model.addAttribute("nationality", new String[]{"Việt Nam", "Lào", "Thái Lan", "Trung",});
        model.addAttribute("gender", new String[]{"Nam", "Nữ", "Bê đê"});
        model.addAttribute("vehicle", new String[]{"Tàu", "Xe máy", "Máy bay", "Đi bộ", "Người yêu cõng"});
        return "create";
    }


    @PostMapping("/create")
    public String displayInformation(@ModelAttribute HealthDeclaration health, Model model) {
        model.addAttribute("health", health);
        return "display";
    }

}
