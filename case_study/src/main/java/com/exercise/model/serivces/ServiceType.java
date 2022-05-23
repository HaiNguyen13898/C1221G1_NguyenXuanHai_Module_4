package com.exercise.model.serivces;

import javax.persistence.*;
import java.util.List;

@Entity
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String serviceTypetName;

    public ServiceType() {
    }

    public ServiceType(int id, String serviceTypetName) {
        this.id = id;
        this.serviceTypetName = serviceTypetName;
    }

    @OneToMany(mappedBy = "serviceType")
    private List<Service> serviceList;

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceTypetName() {
        return serviceTypetName;
    }

    public void setServiceTypetName(String serviceTypetName) {
        this.serviceTypetName = serviceTypetName;
    }
}
