package com.money.controller;
import com.money.service.ChangeMoneyImpl;
import com.money.service.IChangeMoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoneyController {
    @Autowired
    private IChangeMoney changeMoney;

    @GetMapping ("/")
    public String getCaculator () {
        return "calculator";
    }

    @PostMapping ("/change")
    public String changeMoney (@RequestParam Integer usd, Model model) {
        int vnd = changeMoney.changeMoney(usd);
        model.addAttribute("vnd", vnd);
        return "calculator";

    }

}
