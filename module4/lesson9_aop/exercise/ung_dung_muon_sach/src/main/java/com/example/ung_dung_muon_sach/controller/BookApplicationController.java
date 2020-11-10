package com.example.ung_dung_muon_sach.controller;

import com.example.ung_dung_muon_sach.entity.BookApplication;
import com.example.ung_dung_muon_sach.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"/book", ""})
public class BookApplicationController {

    @Autowired
    BookService bookService;

    @GetMapping
    public String list(Model model, @PageableDefault(size = 2) Pageable pageable) {

        model.addAttribute("list", bookService.findAll(pageable));
        return "list";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("book", new BookApplication());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute BookApplication book, Model model, RedirectAttributes redirectAttributes) {
        bookService.save(book);
        redirectAttributes.addFlashAttribute("message", "create a book success");
        return "redirect:/";
    }
}
