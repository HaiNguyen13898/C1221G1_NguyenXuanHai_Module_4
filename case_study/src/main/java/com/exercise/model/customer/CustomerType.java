package com.exercise.model.customer;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="customer_type")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameCusType;

    public CustomerType() {
    }

    public CustomerType(int id, String nameCusType) {
        this.id = id;
        this.nameCusType = nameCusType;
    }

    @OneToMany(mappedBy = "customerType")
    private List<Customer> customerList;

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCusType() {
        return nameCusType;
    }

    public void setNameCusType(String nameCusType) {
        this.nameCusType = nameCusType;
    }
}
