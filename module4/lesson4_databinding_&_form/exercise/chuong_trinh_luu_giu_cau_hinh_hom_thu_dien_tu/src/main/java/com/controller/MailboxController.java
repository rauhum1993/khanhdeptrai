package com.controller;

import com.model.Mail;
import com.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MailboxController {
    @Autowired
    private MailService mailService;

    @GetMapping("/update")
    private String settingMail(Model model) {
        model.addAttribute("mail", mailService.display());
        return "form_edit";
    }

    @GetMapping({"/", "/mail"})
    private String infoMail(Model model) {
        model.addAttribute("mail", mailService.display());
        return "info";
    }

    @PostMapping("/update")
    private String updateMail(@ModelAttribute Mail mail) {
        this.mailService.save(mail);
        return "redirect:/mail";
    }
}
