package com.exercise.repository.contract;

import com.exercise.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
    Page<ContractDetail> findAll2 (Pageable pageable);

}
