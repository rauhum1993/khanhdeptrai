package com.codegym.controller;

import com.codegym.entity.Customer;
import com.codegym.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"/customer",""})
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("list",customerService.fillAll());
        return "list";
    }
    @GetMapping("/create")
    public String formcreate(Model model){
        model.addAttribute("customer",new Customer());
        return "create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Customer customer,Model model){

        customerService.save(customer);
        model.addAttribute("messge","Create success");
        return "redirect:/";
    }
    @GetMapping("/update")
    public String formupdate(@RequestParam Integer id,Model model){
        model.addAttribute("customer",customerService.fillById(id));
        return "update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Customer customer){
        customerService.save(customer);
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String formDelete(@RequestParam Integer id,Model model){
        model.addAttribute("customer",customerService.fillById(id));
        return "delete";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam Integer id){
        customerService.delete(id);
        return "redirect:/";
    }
}
