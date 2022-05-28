package com.exercise.controller.serviceController;


import com.exercise.dto.ServiceDto;
import com.exercise.model.serivces.Service;
import com.exercise.service.services.IRentType;
import com.exercise.service.services.IService;
import com.exercise.service.services.IServiceType;
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
@RequestMapping("/services")
public class ServiceController {
    @Autowired
    private IService iService;

    @Autowired
    private IServiceType serviceType;

    @Autowired
    private IRentType rentType;

    @GetMapping()
    public String showList(Model model,
                           @PageableDefault(value = 3) Pageable pageable) {
        model.addAttribute("servicess", iService.findAll(pageable));
        return "service/list";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        model.addAttribute("serviceType", serviceType.findAll());
        model.addAttribute("rentType", rentType.findAll());
        model.addAttribute("serviceDto", new ServiceDto());
        return "/service/create";
    }


    @PostMapping(value = "/save")
    public String save(@ModelAttribute @Validated ServiceDto serviceDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {

//        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("serviceType", serviceType.findAll());
            model.addAttribute("rentType", rentType.findAll());
            return "/service/create";
        } else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto, service);
            iService.save(service);
            redirectAttributes.addFlashAttribute("message", "Successfully added new");
            return "redirect:/services";
        }
    }


    @GetMapping("/delete")
    public String deleteForm(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Service service = iService.findById(id);
        iService.remove(service);
        redirectAttributes.addFlashAttribute("message", "Successful delete ");
        return "redirect:/services";
    }


}
