package com.exercise.dto;

import com.exercise.model.serivces.RentType;
import com.exercise.model.serivces.ServiceType;

import javax.validation.constraints.NotBlank;

public class ServiceDto {
    private int id;
    @NotBlank
    private String svName;
    @NotBlank
    private String svArea;
    @NotBlank
    private String svCost;
    @NotBlank
    private String maxPeople;
    @NotBlank
    private String standardRoom;
    private String descriptionOtherConvenience;
    private String poolArea;
    private String numberFloor;
    private RentType rentType;
    private ServiceType serviceType;

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

    public ServiceDto() {
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
