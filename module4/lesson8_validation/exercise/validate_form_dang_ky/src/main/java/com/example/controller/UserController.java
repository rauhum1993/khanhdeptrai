package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"","/user"})
public class UserController {

    @Autowired
    UserService userService;

   @RequestMapping(method = RequestMethod.GET)
    public String list(@PageableDefault(size = 3) Pageable pageable, Model model){
        model.addAttribute("list",userService.findAll(pageable));
        return "list";
    }

    @GetMapping("/create")
    public String formCreate(Model model){
       model.addAttribute("user",new User());
       return "create";
    }

    @PostMapping("/create")
    public  String create(@Validated @ModelAttribute User user, BindingResult bindingResult,
                          RedirectAttributes redirectAttributes,Model model,@PageableDefault(size = 3) Pageable pageable){
       new User().validate(user,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("listClassStudent", this.userService.findAll(pageable));
            return "create";
        }

        this.userService.save(user);
        redirectAttributes.addFlashAttribute("message", "Create user success");
       return "redirect:/";
    }


}
