package com.exercise.model.serivces;

import javax.persistence.*;
import java.util.List;

@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String rentTypeName;

    public RentType() {
    }

    @OneToMany(mappedBy = "rentType")
    private List<Service> serviceList;

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    public RentType(int id, String rentTypeName, List<Service> serviceList) {
        this.id = id;
        this.rentTypeName = rentTypeName;
        this.serviceList = serviceList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }


}
