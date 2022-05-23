package com.exercise.service.customer.impl;

import com.exercise.model.customer.CustomerType;
import com.exercise.repository.customer.ICustomerTypeRepository;
import com.exercise.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return this.customerTypeRepository.findAll();
    }
}
