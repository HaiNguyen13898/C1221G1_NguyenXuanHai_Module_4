package com.exercise.model.contract;

import com.exercise.model.customer.Customer;
import com.exercise.model.empolyee.Employee;
import com.exercise.model.serivces.Service;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContract;
    @Column(columnDefinition = "Date")
    private String startDay;
    @Column(columnDefinition = "Date")
    private String enDay;
    private String deposit;

    public Contract() {
    }

    public Contract(int idContract, String startDay, String enDay, String deposit, Employee employee, Service service, Customer customer, List<ContractDetail> contractDetailList) {
        this.idContract = idContract;
        this.startDay = startDay;
        this.enDay = enDay;
        this.deposit = deposit;
        this.employee = employee;
        this.service = service;
        this.customer = customer;
        this.contractDetailList = contractDetailList;
    }

    @ManyToOne
    @JoinColumn(name="idEmployee", referencedColumnName = "idEmployee")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="idService", referencedColumnName = "id")
    private Service service;

    @ManyToOne
    @JoinColumn(name="idCustomer", referencedColumnName = "idCustomer")
    private Customer customer;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    List<ContractDetail> contractDetailList;

    public int getIdContract() {
        return idContract;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEnDay() {
        return enDay;
    }

    public void setEnDay(String enDay) {
        this.enDay = enDay;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }


}
