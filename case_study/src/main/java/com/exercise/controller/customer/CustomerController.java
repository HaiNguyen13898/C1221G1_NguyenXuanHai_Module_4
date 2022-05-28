package com.exercise.controller.customer;


import com.exercise.dto.CustomerDto;
import com.exercise.model.customer.Customer;
import com.exercise.service.customer.ICustomerService;
import com.exercise.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    ICustomerTypeService customerTypeService;

    @GetMapping()
    public String showList(Model model,
                           @PageableDefault(value = 5) Pageable pageable,
                           @RequestParam Optional<String> name,
                           @RequestParam Optional<String> address,
                           @RequestParam Optional<Integer> customerType) {
        String nameVal = name.orElse("");
        String addresss = address.orElse("");
        int cusType = customerType.orElse(-1);
        Page<Customer> customerPage = null;
        if(cusType == -1) {
            customerPage = customerService.findAll1(nameVal, addresss, pageable);
        } else  {
            customerPage = customerService.findAll2(nameVal, addresss, cusType, pageable);
        }
        model.addAttribute("nameVal", nameVal);
        model.addAttribute("addresss", addresss);
        model.addAttribute("cusType", cusType);
        model.addAttribute("customerTypes", customerTypeService.findAll());
        model.addAttribute("customer", customerPage);
        return "customer/list";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        model.addAttribute("customerType", customerTypeService.findAll());
        model.addAttribute("customerDto", new CustomerDto());
        return "/customer/create";
    }


    @PostMapping(value = "/save")
    public String save(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {

//        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerType", customerTypeService.findAll());
            return "/customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "Successfully added new");
            return "redirect:/customers";
        }
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam int id, Model model) {
        model.addAttribute("customerType", customerTypeService.findAll());
        Customer customer = customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        model.addAttribute("customerDto", customerDto);
        return "/customer/edit";
    }

    @PostMapping("/update")
    public String editProduct(@ModelAttribute @Validated CustomerDto customerDto,
                              BindingResult bindingResult, Model model
            ,RedirectAttributes redirectAttributes) {

//        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerType", customerTypeService.findAll());
            return "/customer/edit";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.update(customer);
            redirectAttributes.addFlashAttribute("message", "Successful update ");
            return "redirect:/customers";
        }
    }

    @GetMapping("/delete")
    public String deleteForm(@RequestParam(name = "idCustomer") Integer id, RedirectAttributes redirectAttributes) {
        Customer customer = customerService.findById(id);
        customerService.remove(customer);
        redirectAttributes.addFlashAttribute("message", "Successful delete ");
        return "redirect:/customers";
    }


    @GetMapping("/view")
    public String view(@RequestParam int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/customer/view";
    }


    @GetMapping("/booking")
    public String listBooking(Model model, @PageableDefault() Pageable pageable){
        model.addAttribute("bookings",this.customerService.findBooking(pageable));
        return "/customer/booking";
    }

}
