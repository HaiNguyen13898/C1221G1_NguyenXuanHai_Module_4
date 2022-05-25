package com.exercise.service.contract;

import com.exercise.model.contract.Contract;
import com.exercise.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {

    Page<Contract> findAll(Pageable pageable);

    void save(Contract contract);

    Contract findById(int id);

    void update(Contract contract);

    void remove(Contract contract);
}
