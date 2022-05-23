package com.exercise.model.serivces;

import javax.persistence.*;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String svName;
    private String svArea;
    private String svCost;
    private String maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private String poolArea;
    private String numberFloor;

    public Service() {
    }

    @ManyToOne
    @JoinColumn(name="id_rent_type", referencedColumnName = "id")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "id_service_type", referencedColumnName = "id")
    private ServiceType serviceType;

    public Service(int id, String svName, String svArea, String svCost, String maxPeople, String standardRoom, String descriptionOtherConvenience, String poolArea, String numberFloor) {
        this.id = id;
        this.svName = svName;
        this.svArea = svArea;
        this.svCost = svCost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberFloor = numberFloor;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSvName() {
        return svName;
    }

    public void setSvName(String svName) {
        this.svName = svName;
    }

    public String getSvArea() {
        return svArea;
    }

    public void setSvArea(String svArea) {
        this.svArea = svArea;
    }

    public String getSvCost() {
        return svCost;
    }

    public void setSvCost(String svCost) {
        this.svCost = svCost;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(String numberFloor) {
        this.numberFloor = numberFloor;
    }
}
