package com.exercise.controller;

import com.exercise.dto.UserDto;
import com.exercise.model.User;
import com.exercise.service.IUserService;
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

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("")
    public String showList(Model model, @PageableDefault(value = 2) Pageable pageable) {
        model.addAttribute("userList", this.userService.findAll(pageable));
        return "list";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/create";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute @Validated UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            userService.save(user);
            redirectAttributes.addFlashAttribute("message", "Successfully added new");
            return "redirect:/user";
        }


    }

    @GetMapping("/delete")
    public String deleteForm(@RequestParam int id, RedirectAttributes redirectAttributes) {
        User user = userService.findById(id);
        userService.remove(user);
        redirectAttributes.addFlashAttribute("message", "Successful delete ");
        return "redirect:/user";
    }

}
