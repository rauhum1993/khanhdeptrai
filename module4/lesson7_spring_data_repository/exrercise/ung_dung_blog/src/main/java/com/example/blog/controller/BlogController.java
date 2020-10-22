package com.example.blog.controller;

import com.example.blog.entity.BlogClass;
import com.example.blog.service.BlogService;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"/blog",""})
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, @PageableDefault(size = 3) Pageable pageable){
//        model.addAttribute("list",blogService.findAll());
        model.addAttribute("list",blogService.findAll(pageable));
        return "list";
    }
    @GetMapping("/create")
    public String formCreate(Model model){
        model.addAttribute("blog", new BlogClass());
        model.addAttribute("listCategory",categoryService.findAll());
        return "create";
    }
    @PostMapping("/create")
    public  String create(@ModelAttribute BlogClass blogClass, RedirectAttributes redirectAttributes){
        blogService.save(blogClass);
        redirectAttributes.addFlashAttribute("message","create success");
        return "redirect:/";
    }
}
