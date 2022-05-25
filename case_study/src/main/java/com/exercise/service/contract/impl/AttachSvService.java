package com.exercise.service.contract.impl;

import com.exercise.model.contract.AttachService;
import com.exercise.repository.contract.IAttachServiceRepository;
import com.exercise.service.contract.IAttachSvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachSvService implements IAttachSvService {
    @Autowired
     IAttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
