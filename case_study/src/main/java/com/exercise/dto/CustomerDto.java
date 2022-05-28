package com.exercise.dto;

import com.exercise.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CustomerDto implements Validator {
    private int idCustomer;
    @NotBlank
    private String nameCustomer;
    @NotBlank
    private String dateOfBirth;

    @NotBlank
    private String gender;

    @NotBlank
    @Pattern(regexp = "[0-9]+|", message = "Nhập số, không được nhập chữ (từ 0 đến 9)")
    private String idCard;

    @NotBlank
    @Pattern(regexp = "^((0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}+|)$",
            message = "Nhập số, không được nhập chữ.Số đầu tiên phải là số 0 và tối đa 10 số")
    private String phoneNumber;

    @NotBlank
    @Pattern(regexp = "(^(\\w+.@\\w+.\\w{2,4})+|)$", message = "Sai định dạng (VD: hai@gmail.com)")
    private String email;

    @NotBlank
    private String address;

    private CustomerType customerType;

    public CustomerDto() {
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
