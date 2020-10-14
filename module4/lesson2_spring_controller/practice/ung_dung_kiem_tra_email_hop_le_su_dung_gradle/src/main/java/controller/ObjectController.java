package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ObjectController {
    @GetMapping("/")
    private String webHome(){
        return "home";
    }
}
