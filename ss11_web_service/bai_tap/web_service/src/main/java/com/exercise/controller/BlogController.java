package com.exercise.controller;

import com.exercise.dto.BlogDto;
import com.exercise.model.Blog;
import com.exercise.service.IBlogService;
import com.exercise.service.ICategoryService;
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

import java.util.Optional;


@Controller
@RequestMapping("/blogUD")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showList(Model model,
                           @PageableDefault(value = 2) Pageable pageable,
                           @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");
        model.addAttribute("blogList", blogService.findAndSearchByName(keywordVal, pageable));
        model.addAttribute("keywordVal", keywordVal);
        return "/list";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blogDto", new BlogDto());
        model.addAttribute("categoryList", categoryService.findAll());
        return "/create";
    }


    @PostMapping(value = "/save")
    public String save(@ModelAttribute @Validated BlogDto blogDto,BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("categoryList", categoryService.findAll());
            return "create";
        } else {
            Blog blog = new Blog();
            BeanUtils.copyProperties(blogDto, blog);
            blogService.save(blog);
            redirectAttributes.addFlashAttribute("message", "Successfully added new");
            return "redirect:/blogUD";
        }
    }
    @GetMapping("/edit")
    public String editForm(@RequestParam int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categoryList", categoryService.findAll());
        return "/edit";
    }

    @PostMapping("/update")
    public String editProduct(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.update(blog);
        redirectAttributes.addFlashAttribute("message", "Successful update ");
        return "redirect:/blogUD";
    }

    @GetMapping("/delete")
    public String deleteForm(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Blog blog = blogService.findById(id);
        blogService.remove(blog);
        redirectAttributes.addFlashAttribute("message", "Successful delete ");
        return "redirect:/blogUD";
    }


}
