package com.example.customer.controller;

import com.example.customer.entity.Customer;
import com.example.customer.entity.TypeCustomer;
import com.example.customer.repository.TypeCustomerRepository;
import com.example.customer.service.CutomerService;
import com.example.customer.service.TypeCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping({"/customer", ""})
public class CustomerController {

    @Autowired
    private CutomerService cutomerService;

    @Autowired
    private TypeCustomerService typeCustomerService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, @PageableDefault(size = 3) Pageable pageable, @RequestParam Optional<String> keyword) {

        String keyWordOld = "";
        if (keyword.isPresent()) {
            keyWordOld = keyword.get();
            model.addAttribute("list", cutomerService.findByNameContaining(pageable, keyWordOld));
        } else {
            model.addAttribute("list", cutomerService.findAll(pageable));
        }
        model.addAttribute("keywordOld", keyWordOld);
        return "list";
    }


    @GetMapping("/create")
    public String formcreate(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("listTypeCustomer", typeCustomerService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Customer customer, Model model, RedirectAttributes redirectAttributes) {

        cutomerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Create success");
        return "redirect:/";
    }

    @GetMapping("/update")
    public String formupdate(@RequestParam Integer id, Model model) {
        model.addAttribute("customer", cutomerService.fillById(id));
        model.addAttribute("listTypeCustomer", typeCustomerService.findAll());
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Customer customer) {
        cutomerService.save(customer);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String formDelete(@RequestParam Integer id, Model model) {
        model.addAttribute("customer", cutomerService.fillById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id) {
        cutomerService.delete(id);
        return "redirect:/";
    }
}
