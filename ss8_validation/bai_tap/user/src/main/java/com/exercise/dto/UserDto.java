package com.exercise.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {

    private int id;

    @NotBlank(message = "không được để trống")
    @Size(min = 5, max = 45)
    private String name;

    @Pattern(regexp = "^[1-9][0-9]+$", message = "Không được âm")
    private String phoneNumber;

    @Min(value = 18,message = "phải trên 18+")
    @Max(value = 90, message = "sống lâu quá không được")
    private String age;

    private String email;

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
//        if (!userDto.getAge().matches("^[1-9][0-9]+$")) {
//            errors.rejectValue("age", "age_errors", "lỗi a");
//        } else if (userDto.getAge() == null) {
//            errors.rejectValue("age", "age_errors_2", "lỗi b");
//        }

    }
}
