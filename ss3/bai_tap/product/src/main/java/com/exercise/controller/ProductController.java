package com.exercise.controller;

import com.exercise.model.Product;
import com.exercise.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showList(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }


    @PostMapping(value = "/save")
    public String save(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("message","Successfully added new");
        return "redirect:/product";
    }

    @GetMapping("/edit")
    public String editForm (@RequestParam int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String editProduct (@ModelAttribute Product product,RedirectAttributes redirectAttributes){
        productService.update(product.getId(),product);
        redirectAttributes.addFlashAttribute("message","Successful update ");
        return "redirect:/product";
    }


}
