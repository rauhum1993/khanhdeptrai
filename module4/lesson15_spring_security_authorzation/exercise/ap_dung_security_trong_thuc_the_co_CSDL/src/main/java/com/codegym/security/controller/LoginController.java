package com.codegym.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(value = "userLogin")
public class LoginController {

    @GetMapping(value = "/login")
    public String goLogin() {
        return "login";
    }

    @GetMapping("/403")
    public String go403() {
        return "403";
    }
}
