package com.exercise.dto;

import com.exercise.model.empolyee.Division;
import com.exercise.model.empolyee.EducationDegree;
import com.exercise.model.empolyee.Position;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class EmployeeDto implements Validator {
    private int idEmployee;
    @NotBlank
    private String nameEmployee;

    private String dateBirth;

    @NotBlank
    @Pattern(regexp = "[0-9]+|", message = "Nhập số, không được nhập chữ (từ 0 đến 9)")
    private String idCardEmployee;

    private String salary;
    @NotBlank
    @Pattern(regexp = "^((0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}+|)$",
            message = "Nhập số, không được nhập chữ.Số đầu tiên phải là số 0 và tối đa 10 số")
    private String phoneNumber;

    @NotBlank
    @Pattern(regexp = "(^(\\w+.@\\w+.\\w{2,4})+|)$", message = "Sai định dạng (VD: hai@gmail.com)")
    private String email;

    @NotBlank
    private String address;

    private Position position;
    private EducationDegree educationDegree;
    private Division division;

    public EmployeeDto() {
    }

    public EmployeeDto(int idEmployee, String nameEmployee, String dateBirth, String idCardEmployee, String salary, String phoneNumber, String email, String address, Position position, EducationDegree educationDegree, Division division) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.dateBirth = dateBirth;
        this.idCardEmployee = idCardEmployee;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getIdCardEmployee() {
        return idCardEmployee;
    }

    public void setIdCardEmployee(String idCardEmployee) {
        this.idCardEmployee = idCardEmployee;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
