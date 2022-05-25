package com.exercise.model.contract;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;

    public ContractDetail() {
    }

    public ContractDetail(int id, int quantity, Contract contract) {
        this.id = id;
        this.quantity = quantity;
        this.contract = contract;
    }


    @ManyToOne
    @JoinColumn(name="idContract", referencedColumnName = "idContract")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "idAttchService", referencedColumnName = "id")
    private AttachService attachService;


    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
