package com.product.controller;

import com.product.model.Product;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String display(Model model){
        model.addAttribute("productList",productService.fillAll());
        return "home";
    }
    @GetMapping("/product/create")
    public String formCreate(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/product/create")
    public String save(@ModelAttribute Product product,Model model){
        productService.save(product);
        model.addAttribute("productList",productService.fillAll());
        return "redirect:/";
    }
    @GetMapping("/product/edit/{id}")
    public String formEdit(Model model, @PathVariable String id){
        model.addAttribute("product",productService.fillByID(id));
        return "edit";
    }

    @PostMapping("/product/edit")
    public String update(Model model,@ModelAttribute Product product){
        productService.update(product);
        model.addAttribute("productList",productService.fillAll());
        return "redirect:/";
    }
    @GetMapping("/product/delete/{id}")
    public String formDelete(Model model,@PathVariable String id){
        model.addAttribute("product",productService.fillByID(id));
        return "delete";
    }
    @PostMapping("/product/delete")
    public String delete(Model model,@ModelAttribute Product product){
        productService.delete(product);
        return "redirect:/";
    }
    @GetMapping("/product/view/{id}")
    public String view(Model model,@PathVariable String id){
        model.addAttribute("product",productService.fillByID(id));
        return "view";
    }

}
