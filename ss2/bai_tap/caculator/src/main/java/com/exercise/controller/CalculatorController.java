package com.exercise.controller;

import com.exercise.service.ICalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class CalculatorController {

    @Autowired
    private ICalculator iCalculator;

    @RequestMapping(value = "/calculators", method = RequestMethod.GET)
    public String viewCalculator() {
        return "calculator";
    }


    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String getResult(@RequestParam double a, @RequestParam double b, @RequestParam String cal, Model model) {
        double sums = iCalculator.addition(a, b);
        double subtractions = iCalculator.subtraction(a, b);
        double multiplications = iCalculator.multiplication(a, b);
        double divisions = iCalculator.division(a, b);
        if (cal.equals("Addition(+)")) {
            model.addAttribute("result", sums);
            return "calculator";
        } else if (cal.equals("Subtraction(-)")) {
            model.addAttribute("result", subtractions);
            return "calculator";
        } else if (cal.equals("Multiplication(x)")) {
            model.addAttribute("result", multiplications);
            return "calculator";
        } else {
            model.addAttribute("result", divisions);
            return "calculator";
        }

    }

}
