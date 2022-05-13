package com.exercise.dto;

import com.exercise.model.TypeProduct;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductDto implements Validator {
    private int id;

    @NotBlank(message = "Name must not be left blank")
    private String productName;

    @NotNull(message = "Can't left it blank")
    private Double price;

    @NotBlank(message = "Can't left it blank")
    private String descriptions;

    @NotBlank(message = "Can't left it blank")
    private String producer;

    private TypeProduct typeProduct;

    public ProductDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto = (ProductDto) target;
        if (!productDto.getProductName().matches("^([a-zA-Z ]+[ a-zA-Z!()]+|)$")) {
            errors.rejectValue("productName", "name_product", "wrong format!!");
        }

        if(!productDto.getDescriptions().matches("^([A-zA-Z ]+[ a-zA-Z!()]+|)$")){
            errors.rejectValue("descriptions", "descriptions_product", "wrong format!!");
        }

    }
}
