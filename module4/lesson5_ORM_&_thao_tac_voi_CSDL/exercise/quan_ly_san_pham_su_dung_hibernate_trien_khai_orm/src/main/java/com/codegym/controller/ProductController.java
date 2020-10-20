package com.codegym.controller;


import com.codegym.entity.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"/product", ""})
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
//    @GetMapping(value = "/")
    public String goListProduct(Model model) {

        model.addAttribute("listProduct", productService.findAll());

        return "list_product";
    }

    @GetMapping("/detail")
    public String goDetailProduct(@RequestParam Integer id, Model model) {
        model.addAttribute("productDetail", productService.findbyId(id));
        return "detail_product";
    }

    @GetMapping("/detail/{idProduct}")
    public String goDetailProductPathVariable(@PathVariable(value = "idProduct") Integer id, Model model) {
        model.addAttribute("studentDetail", productService.findbyId(id));
        return "detail_product";
    }

    @GetMapping("/create")
    public String goCreateProduct(Model model) {
        model.addAttribute("product", new Product());

        return "create_product";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {

        this.productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Create product OK!");

        return "redirect:/product";
    }
}
