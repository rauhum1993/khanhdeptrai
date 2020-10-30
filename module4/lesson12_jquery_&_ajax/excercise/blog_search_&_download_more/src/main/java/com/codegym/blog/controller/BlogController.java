package com.codegym.blog.controller;

import com.codegym.blog.entity.Blog;
import com.codegym.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"/blog",""})
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping
    public String list(Model model){
        model.addAttribute("list",blogService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String formCreate(Model model){
        model.addAttribute("blog", new Blog());

        return  "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, Model model, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addAttribute("message","create success");
        return "redirect:/";
    }

}
