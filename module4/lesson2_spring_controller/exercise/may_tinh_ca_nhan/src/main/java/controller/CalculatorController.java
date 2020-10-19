package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/home")
    public String calculator(@RequestParam String result,
                             @RequestParam String number1,
                             @RequestParam String number2,
                             Model model) {
        if (result == "addition") {
            model.addAttribute("result", (Integer.parseInt(number1) + Integer.parseInt(number2)));
        } else if (result == "subtraction") {
            model.addAttribute("result", (Integer.parseInt(number1) - Integer.parseInt(number2)));
        } else if (result == "multiplication") {
            model.addAttribute("result", (Integer.parseInt(number1) * Integer.parseInt(number2)));
        } else  if (result == "division") {
            model.addAttribute("result", (Integer.parseInt(number1) /Integer.parseInt(number2)));
        }

        return "home";
    }
}
