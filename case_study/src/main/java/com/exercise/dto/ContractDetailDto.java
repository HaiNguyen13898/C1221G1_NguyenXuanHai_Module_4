package com.exercise.dto;

import com.exercise.model.contract.AttachService;
import com.exercise.model.contract.Contract;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ContractDetailDto {
    private int id;
    @NotNull
    private int quantity;
    private Contract contract;
    private AttachService attachService;

    public ContractDetailDto() {
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

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
