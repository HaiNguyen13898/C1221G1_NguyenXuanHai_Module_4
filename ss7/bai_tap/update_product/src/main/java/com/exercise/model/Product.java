package com.exercise.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productName;
    private Double price;
    private String description;
    private String producer;

    public Product() {
    }

    @ManyToOne
    @JoinColumn(name="id_type_product", referencedColumnName = "id")
    private TypeProduct typeProduct;

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    public Product(String productName, Double price, String description, String producer, TypeProduct typeProduct) {
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.producer = producer;
        this.typeProduct = typeProduct;
    }

    public Product(int id, String productName, Double price, String description, String producer, TypeProduct typeProduct) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.producer = producer;
        this.typeProduct = typeProduct;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
