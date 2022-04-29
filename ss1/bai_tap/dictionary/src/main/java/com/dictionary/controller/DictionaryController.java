package com.dictionary.controller;

import com.dictionary.service.ITranslate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.PrintWriter;

@Controller
public class DictionaryController {

    @Autowired
    private ITranslate translate;

    @GetMapping("")
    public String dictionary() {
        return "dictionary";
    }

    @PostMapping("search")
    public String search (@RequestParam String search, Model model) {
        String result = translate.dictionary(search);
        model.addAttribute("result", result);
        return "result";

    }


}
