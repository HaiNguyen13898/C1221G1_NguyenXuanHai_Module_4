package com.exercise.repository.contract;

import com.exercise.model.contract.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAttachServiceRepository extends JpaRepository<AttachService, Integer> {
}
