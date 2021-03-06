package com.exercise.controller.employeeController;

import com.exercise.dto.EmployeeDto;
import com.exercise.model.empolyee.Employee;
import com.exercise.service.employee.IDivisionService;
import com.exercise.service.employee.IEducationDegreeService;
import com.exercise.service.employee.IEmployeeService;
import com.exercise.service.employee.IPositionService;
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
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IDivisionService divisionService;
    @Autowired
    IPositionService positionService;
    @Autowired
    IEducationDegreeService educationDegreeService;


    @GetMapping("")
    public String showList (Model model, @PageableDefault(value = 4) Pageable pageable,
                            @RequestParam Optional<String> name,
                            @RequestParam Optional<Integer> position,
                            @RequestParam Optional<Integer> division,
                            @RequestParam Optional<Integer> education)
    {
        String nameEmployee = name.orElse("");
        int pos = position.orElse(-1);
        int div = division.orElse(-1);
        int edu = education.orElse(-1);
        Page<Employee>  employeePage = null;
        if(pos == -1 || div == -1 || edu == -1){
            employeePage = employeeService.findAllAndSearchName(nameEmployee, pageable);
        } else {
            employeePage = employeeService.findAllAndSearch(nameEmployee, pos, div, edu, pageable);
        }
        model.addAttribute("name", nameEmployee);
        model.addAttribute("pos", pos);
        model.addAttribute("div", div);
        model.addAttribute("edu", edu);
        model.addAttribute("division", divisionService.findAll());
        model.addAttribute("position", positionService.findAll());
        model.addAttribute("education", educationDegreeService.findAll());
        model.addAttribute("employeess", employeePage);
        return "/employee/list";
    }


    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        model.addAttribute("division", divisionService.findAll());
        model.addAttribute("position", positionService.findAll());
        model.addAttribute("education", educationDegreeService.findAll());
        model.addAttribute("employeeDto", new EmployeeDto());
        return "/employee/create";
    }


    @PostMapping(value = "/save")
    public String save(@ModelAttribute @Validated EmployeeDto employeeDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {

//        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("division", divisionService.findAll());
            model.addAttribute("position", positionService.findAll());
            model.addAttribute("education", educationDegreeService.findAll());
            return "/employee/create";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "Successfully added new");
            return "redirect:/employees";
        }
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam int id, Model model) {
        model.addAttribute("division", divisionService.findAll());
        model.addAttribute("position", positionService.findAll());
        model.addAttribute("education", educationDegreeService.findAll());
        Employee employee = employeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        model.addAttribute("employeeDto", employeeDto);
        return "/employee/edit";
    }

    @PostMapping("/update")
    public String editProduct(@ModelAttribute @Validated EmployeeDto employeeDto,
                              BindingResult bindingResult, Model model
            ,RedirectAttributes redirectAttributes) {

//        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("division", divisionService.findAll());
            model.addAttribute("position", positionService.findAll());
            model.addAttribute("education", educationDegreeService.findAll());
            return "/employee/edit";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.update(employee);
            redirectAttributes.addFlashAttribute("message", "Successful update ");
            return "redirect:/employees";
        }
    }

    @GetMapping("/delete")
    public String deleteForm(@RequestParam int idEmployee, RedirectAttributes redirectAttributes) {
        Employee employee = employeeService.findById(idEmployee);
        employeeService.remove(employee);
        redirectAttributes.addFlashAttribute("message", "Successful delete ");
        return "redirect:/employees";
    }


    @GetMapping("/view")
    public String view(@RequestParam int id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "/employee/view";
    }


}
