package com.exercise.controller.contract;

import com.exercise.dto.ContractDetailDto;
import com.exercise.dto.ContractDto;
import com.exercise.model.contract.Contract;
import com.exercise.model.contract.ContractDetail;
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


    @GetMapping("")
    public String showList(Model model, @PageableDefault(value = 4) Pageable pageable) {
        model.addAttribute("contractDetail", iContractDetailService.findAll2(pageable));
        return "/contractDetail/list";
    }


    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        model.addAttribute("attachSV", iAttachSvService.findAll());
        model.addAttribute("contracts", iContractService.findAll2());
        model.addAttribute("contractDetailDto", new ContractDetailDto());
        return "/contractDetail/create";
    }


    @PostMapping(value = "/save")
    public String save(@ModelAttribute @Validated ContractDetailDto contractDetailDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("attachSV", iAttachSvService.findAll());
            model.addAttribute("contracts", iContractService.findAll2());
            return "/contractDetail/create";
        } else {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto, contractDetail);
            iContractDetailService.save(contractDetail);
            redirectAttributes.addFlashAttribute("message", "Successfully added new");
            return "redirect:/contractDetail";
        }
    }


}
