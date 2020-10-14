package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmailController {

        @GetMapping("/")
        private String webHome(){
            return "index";
        }

}
