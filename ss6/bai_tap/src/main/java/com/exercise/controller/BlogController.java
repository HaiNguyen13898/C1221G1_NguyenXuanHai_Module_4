package com.exercise.controller;

import com.exercise.model.Blog;
import com.exercise.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/blogs")
    public String showList(Model model) {
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList", blogList);
        return "list";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }


    @PostMapping(value = "/save")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Successfully added new");
        return "redirect:/blogs";
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String editProduct(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.update(blog);
        redirectAttributes.addFlashAttribute("message", "Successful update ");
        return "redirect:/blogs";
    }

    @GetMapping("/delete")
    public String deleteForm(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Blog blog = blogService.findById(id);
        blogService.remove(blog);
        redirectAttributes.addFlashAttribute("message", "Successful delete ");
        return "redirect:/blogs";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam String name,Model model){
        List<Blog> blogList = blogService.searchByName(name);
        if (blogList.isEmpty()) {
            model.addAttribute("message", "Not found any product");
        } else {
            model.addAttribute("blogList", blogList);
        }
        return "list";
    }

}
