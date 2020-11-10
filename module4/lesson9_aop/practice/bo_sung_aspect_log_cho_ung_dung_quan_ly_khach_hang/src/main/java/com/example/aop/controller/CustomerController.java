package com.example.aop.controller;

import com.example.aop.entity.Customer;
import com.example.aop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"/customer", ""})
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public String list(Model model, @PageableDefault(size = 2) Pageable pageable) {
        model.addAttribute("list", customerService.findAll(pageable));
        return "list";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {

        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "create a customer success");
        return "redirect:/";
    }

    @GetMapping("/update")
    public String formUpdate(@RequestParam Integer id, Model model) throws Exception {
        model.addAttribute("customerUpdate", customerService.findById(id));

        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Customer customer, Model model, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "update success");
        return "redirect:/";

    }

}


