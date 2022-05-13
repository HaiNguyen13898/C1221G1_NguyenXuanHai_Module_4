package com.exercise.controller;

import com.exercise.model.Product;
import com.exercise.service.IProductService;
import com.exercise.service.ITypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ITypeProductService typeProductService;

    @GetMapping("")
    public String showList(Model model,
                           @PageableDefault(value = 4) Pageable pageable
            , @RequestParam Optional<String> key, @RequestParam Optional<String> des){
        String keyVal = key.orElse("");
        String desVal = des.orElse("");
        model.addAttribute("desVal", desVal);
        model.addAttribute("keyVal", keyVal);
        model.addAttribute("productList", productService.findAllsearchByName(keyVal,desVal, pageable));
        return "list";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        model.addAttribute("typeProducts", typeProductService.findAll());
        model.addAttribute("product", new Product());
        return "/create";
    }


    @PostMapping(value = "/save")
    public String save(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Successfully added new");
        return "redirect:/product";
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam int id, Model model) {
        model.addAttribute("typeProduct", typeProductService.findAll());
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String editProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.update(product);
        redirectAttributes.addFlashAttribute("message", "Successful update ");
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String deleteForm(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Product product = productService.findById(id);
        productService.remove(product);
        redirectAttributes.addFlashAttribute("message", "Successful delete ");
        return "redirect:/product";
    }


    @GetMapping("/view")
    public String view(@RequestParam int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }

//    @GetMapping("/search")
//    public String searchByName(@RequestParam String nameProduct,Model model){
//        List<Product> productList = productService.searchByName(nameProduct);
//        if (productList.isEmpty()) {
//            model.addAttribute("message", "Not found any product");
//        } else {
//            model.addAttribute("productList", productList);
//        }
//        return "list";
//    }
}