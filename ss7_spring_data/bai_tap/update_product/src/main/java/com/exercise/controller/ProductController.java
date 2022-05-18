package com.exercise.controller;

import com.exercise.dto.ProductDto;
import com.exercise.model.Product;
import com.exercise.service.IProductService;
import com.exercise.service.ITypeProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
            , @RequestParam Optional<String> key, @RequestParam Optional<String> des) {
        String keyVal = key.orElse("");
        String desVal = des.orElse("");
        model.addAttribute("desVal", desVal);
        model.addAttribute("keyVal", keyVal);
        model.addAttribute("productList", productService.findAllsearchByName(keyVal, desVal, pageable));
        return "list";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        model.addAttribute("typeProducts", typeProductService.findAll());
        model.addAttribute("productDto", new ProductDto());
        return "/create";
    }


    @PostMapping(value = "/save")
    public String save(@ModelAttribute @Validated ProductDto productDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {

        new ProductDto().validate(productDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("typeProducts", typeProductService.findAll());
            return "/create";
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            productService.save(product);
            redirectAttributes.addFlashAttribute("message", "Successfully added new");
            return "redirect:/product";
        }
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam int id, Model model) {
        model.addAttribute("typeProduct", typeProductService.findAll());
        Product product = productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        model.addAttribute("productDto", productDto);
        return "edit";
    }

    @PostMapping("/update")
    public String editProduct(@ModelAttribute @Validated ProductDto productDto,
                              BindingResult bindingResult, Model model
            ,RedirectAttributes redirectAttributes) {

        new ProductDto().validate(productDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("typeProduct", typeProductService.findAll());
            return "edit";
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            productService.update(product);
            redirectAttributes.addFlashAttribute("message", "Successful update ");
            return "redirect:/product";
        }
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


}
