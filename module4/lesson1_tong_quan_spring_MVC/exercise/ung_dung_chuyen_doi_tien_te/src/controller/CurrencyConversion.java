package controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConversion {
    @GetMapping("/")
    private String webHome() {

        return "currency_conversion";
    }

    @GetMapping("/result")
    public String result(@RequestParam String usaMoney, @RequestParam String vndMoney, Model model) {
        double result = Double.parseDouble(usaMoney) * 22000;
        model.addAttribute("result", result);
        return "display";
    }

}
