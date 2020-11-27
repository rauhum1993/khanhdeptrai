package com.example.module4.controller;


import com.example.module4.entity.Customer;
import com.example.module4.service.CustomerService;
import com.example.module4.service.TypeCustomerService;
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
@RequestMapping({"/customer",""})
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TypeCustomerService typeCustomerService;

//    @GetMapping
//    public String listCustomer(Model model) {
//        model.addAttribute("listCustomer", customerService.findAll());
//        return "list_customer";
//    }

    //    -----------------------------------------------------------
//@RequestMapping(method = RequestMethod.GET)
////    @GetMapping(value = "/")
//public String goListStudent(Model model, @PageableDefault(size = 2) Pageable pageable,
//                            @RequestParam Optional<String> keyword) {
////                                @SessionAttribute("userLogin") User user) {
//
//    String keywordOld = "";
//
//    if (keyword.isPresent()) {
//        keywordOld = keyword.get();
//        model.addAttribute("listStudent", studentService.findByNameContaining(pageable, keywordOld));
//    } else {
//        model.addAttribute("listStudent", studentService.findAll(pageable));
//    }
//
//    model.addAttribute("keywordOld", keywordOld);
////        model.addAttribute("userLogin", user);
//
//    return "list_student";
//}
    //-----------------------------------------------------------------------------
    @GetMapping
    public String listCustomer(Model model,
                               @PageableDefault(size = 2) Pageable pageable,
                               @RequestParam(value = "keyword", defaultValue = "") String keyword,
                               @RequestParam(value = "searchEmail", defaultValue = "") String searchEmail,
                               @RequestParam(defaultValue = "") String sortByName) {
        String keywordOld = "";

        if ( (("").equals(keyword)) && (("").equals(searchEmail)) && sortByName.equals("")) {
//            keywordOld = keyword.get();
            model.addAttribute("listCustomer", customerService.findAll(pageable));


        } else if(sortByName.equals("Sort")){
            model.addAttribute("listCustomer",customerService.sortByName(pageable));
        }
        else  {
            model.addAttribute("listCustomer", customerService.searchStudentByNameOrByEmail(pageable, keyword,searchEmail));
        }
//        } if(!("").equals(searchEmail)){
//            model.addAttribute("listCustomer", customerService.findAllByEmailContaining(pageable, searchEmail));
//        }

        model.addAttribute("listTypeCustomer", this.typeCustomerService.findAll());
        model.addAttribute("keyword", keyword);
        model.addAttribute("searchEmail", searchEmail);
        model.addAttribute("customer1", new Customer());
        model.addAttribute("customer2", new Customer());

        return "list_customer";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("listTypeCustomer", typeCustomerService.findAll());
        model.addAttribute("customer", new Customer());

        return "create_customer";
    }

    @PostMapping("/create")
    public String createCustomer(@Validated
                                 @ModelAttribute Customer customer,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {


        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("listTypeCustomer", this.typeCustomerService.findAll());

            return "create_customer";
        }

        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Create success a new customer");
        return "redirect:/customer";

    }

    @PostMapping("/createModal")
    public String createCustomerModal(@Validated
                                      @ModelAttribute("customer2") Customer customer,
                                      BindingResult bindingResult,
                                      @PageableDefault(size = 2) Pageable pageable,
                                      Model model) {


        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("listTypeCustomer", this.typeCustomerService.findAll());
            model.addAttribute("listCustomer", customerService.findAll(pageable));
            model.addAttribute("customer1", new Customer());
            return "list_customer";
        }

        this.customerService.save(customer);
        model.addAttribute("listTypeCustomer", this.typeCustomerService.findAll());
        model.addAttribute("listCustomer", customerService.findAll(pageable));
        model.addAttribute("customer1", new Customer());
        model.addAttribute("customer2", new Customer());
        return "list_customer";

    }

    @GetMapping("/update")
    public String formUpdateCustomer(Model model, @RequestParam String id) {
        model.addAttribute("customer", this.customerService.findById(id));
        model.addAttribute("listTypeCustomer", typeCustomerService.findAll());
        return "update_customer";

    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute Customer customer,

                                 RedirectAttributes redirectAttributes) {
        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Update success customer ");
        return "redirect:/customer";
    }

    @PostMapping("/updateModal")
    public String updateModalCustomer(@Validated @ModelAttribute("customer1") Customer customer,
                                      BindingResult bindingResult,
                                      @PageableDefault(size = 2) Pageable pageable,
                                      Model model

    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listCustomer", customerService.findAll(pageable));
            model.addAttribute("listTypeCustomer", this.typeCustomerService.findAll());
            model.addAttribute("customer2", new Customer());
            return "list_customer";
        }
        model.addAttribute("listTypeCustomer", this.typeCustomerService.findAll());
        model.addAttribute("listCustomer", customerService.findAll(pageable));
        model.addAttribute("customer1", new Customer());
        model.addAttribute("customer2", new Customer());
        this.customerService.save(customer);
        return "list_customer";

    }

    @GetMapping("/delete")
    public String formDeleteCustomer(Model model, @RequestParam String id) {
        model.addAttribute("customer", this.customerService.findById(id));
        return "delete_customer";
    }

    //    @PostMapping("/delete")
//    public String deleteCustomer(@RequestParam Integer customerId,
//                                 RedirectAttributes redirectAttributes) {
//        this.customerService.deleteById(customerId);
//        redirectAttributes.addFlashAttribute("message", "Delete success a customer ");
//        return "redirect:/customer";
//    }
    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute Customer customer,
                                 RedirectAttributes redirectAttributes) {
        this.customerService.delete(customer);
        redirectAttributes.addFlashAttribute("message", "Delete success a customer ");
        return "redirect:/customer";
    }

    @GetMapping("deleteModal")
    public String deleteModalCustomer(@RequestParam String id,
                                      RedirectAttributes redirectAttributes) {
        this.customerService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Delete success a customer ");
        return "redirect:/customer";
    }


}
