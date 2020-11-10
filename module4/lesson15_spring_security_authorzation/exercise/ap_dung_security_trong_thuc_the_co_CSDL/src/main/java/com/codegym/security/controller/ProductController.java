package com.codegym.security.controller;

import com.codegym.security.service.CategoryService;
import com.codegym.security.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("listProduct", productService.findALl());
        return "/list_product";
    }


}
