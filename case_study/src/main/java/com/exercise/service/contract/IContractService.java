package com.exercise.service.contract;

import com.exercise.model.contract.Contract;
import com.exercise.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {

    Page<Contract> findAll(Pageable pageable);

    List<Contract> findAll2();

    void save(Contract contract);

    Contract findById(int id);

    void update(Contract contract);

    void remove(Contract contract);
}
