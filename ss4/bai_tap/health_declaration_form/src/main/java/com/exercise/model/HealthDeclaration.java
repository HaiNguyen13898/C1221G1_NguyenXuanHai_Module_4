package com.exercise.model;

public class HealthDeclaration {
    private String name;
    private String birthDate;
    private String gender;
    private String nationality;
    private String idCard;
    private String vehicle;
    private String codeVehicle;
    private String seats;
    private String startDay;
    private String endDay;
    private String exposureHistory;

    public HealthDeclaration() {
    }

    public HealthDeclaration(String name, String birthDate, String gender, String nationality, String idCard, String vehicle, String codeVehicle, String seats, String startDay, String endDay, String exposureHistory) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.nationality = nationality;
        this.idCard = idCard;
        this.vehicle = vehicle;
        this.codeVehicle = codeVehicle;
        this.seats = seats;
        this.startDay = startDay;
        this.endDay = endDay;
        this.exposureHistory = exposureHistory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getCodeVehicle() {
        return codeVehicle;
    }

    public void setCodeVehicle(String codeVehicle) {
        this.codeVehicle = codeVehicle;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getExposureHistory() {
        return exposureHistory;
    }

    public void setExposureHistory(String exposureHistory) {
        this.exposureHistory = exposureHistory;
    }
}
