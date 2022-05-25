package com.exercise.dto;

import com.exercise.model.customer.Customer;
import com.exercise.model.empolyee.Employee;
import com.exercise.model.serivces.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;


public class ContractDto implements Validator {
    private int idContract;
    @NotBlank
    private String startDay;
    @NotBlank
    private String enDay;
    private String deposit;
    private Employee employee;
    private Service service;
    private Customer customer;

    public ContractDto() {
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEnDay() {
        return enDay;
    }

    public void setEnDay(String enDay) {
        this.enDay = enDay;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
