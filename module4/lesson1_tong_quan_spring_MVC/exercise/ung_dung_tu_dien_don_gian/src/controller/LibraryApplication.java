package controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

public class LibraryApplication {


    List<String> customer = new ArrayList<>();


    @GetMapping("/")
    private String library() {

        return "search";
    }

    @GetMapping("/result")
    private String result(@RequestParam String search, Model model){
        customer.add("Dat");
        customer.add("hai");
        customer.add("Nhat");
        customer.add("chanh");
        return "result";
    }


}
