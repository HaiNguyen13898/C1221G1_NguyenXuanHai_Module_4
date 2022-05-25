package com.exercise.service.contract;

import com.exercise.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();

    Page<ContractDetail> findAll2(Pageable pageable);

    void save(ContractDetail contractDetail);
}
