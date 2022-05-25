package com.exercise.controller.contract;

import com.exercise.dto.ContractDto;
import com.exercise.model.contract.Contract;
import com.exercise.service.contract.IAttachSvService;
import com.exercise.service.contract.IContractDetailService;
import com.exercise.service.contract.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contractDetail")
public class ContractDetailController {
    @Autowired
    private IContractService iContractService;

    @Autowired
    private IAttachSvService iAttachSvService;

    @Autowired
    private IContractDetailService iContractDetailService;


    @GetMapping()
    public String showList(Model model, @PageableDefault(value = 4) Pageable pageable) {
        model.addAttribute("contractDetail", iContractDetailService.findAll2(pageable));
        return "contractDetail/list";
    }

//    @GetMapping(value = "/create")
//    public String showCreateForm(Model model) {
//        model.addAttribute("employees", employeeService.findAll2());
//        model.addAttribute("customers", customerService.findAll3());
//        model.addAttribute("services", service.findAll2());
//        model.addAttribute("contractDto", new ContractDto());
//        return "/contract/create";
//    }
//
//
//    @PostMapping(value = "/save")
//    public String save(@ModelAttribute @Validated ContractDto contractDto,
//                       BindingResult bindingResult,
//                       RedirectAttributes redirectAttributes, Model model) {
//
//        new ContractDto().validate(contractDto, bindingResult);
//        if (bindingResult.hasFieldErrors()) {
//            model.addAttribute("employees", employeeService.findAll2());
//            model.addAttribute("customers", customerService.findAll3());
//            model.addAttribute("services", service.findAll2());
//            return "/contract/create";
//        } else {
//            Contract contract = new Contract();
//            BeanUtils.copyProperties(contractDto, contract);
//            contractService.save(contract);
//            redirectAttributes.addFlashAttribute("message", "Successfully added new");
//            return "redirect:/contracts";
//        }
//    }



}
