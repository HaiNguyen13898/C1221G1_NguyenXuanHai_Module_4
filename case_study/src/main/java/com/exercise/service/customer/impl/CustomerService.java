package com.exercise.service.customer.impl;

import com.exercise.model.customer.Customer;
import com.exercise.repository.customer.ICustomerRepository;
import com.exercise.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;


    @Override
    public Page<Customer> findAllAndSearch(String name, String address, String phone, Pageable pageable) {
        return this.customerRepository.findAllByNameCustomerContainingAndAddressContainingAndPhoneNumberContaining(name, address, phone, pageable);
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return this.customerRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public void remove(Customer customer) {
        this.customerRepository.delete(customer);
    }
}
