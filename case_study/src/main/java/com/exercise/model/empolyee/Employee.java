package com.exercise.model.empolyee;

import com.exercise.model.contract.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmployee;
    private String nameEmployee;
    private String dateBirth;
    private String idCardEmployee;
    private String salary;
    private String phoneNumber;
    private String email;
    private String address;

    public Employee() {
    }

    @ManyToOne
    @JoinColumn(name = "idPosition", referencedColumnName = "idPosition")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "idEducation", referencedColumnName = "idEducation")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "idDivision", referencedColumnName = "idDivision")
    private Division division;


    @OneToMany(mappedBy = "employee")
    private List<Contract> contractList;

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
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

    public Employee(int idEmployee, String nameEmployee, String dateBirth, String idCardEmployee, String salary, String phoneNumber, String email, String address) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.dateBirth = dateBirth;
        this.idCardEmployee = idCardEmployee;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
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
}
