package com.exercise.service.customer.impl;

import com.exercise.dto.Booking;
import com.exercise.model.customer.Customer;
import com.exercise.repository.customer.ICustomerRepository;
import com.exercise.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;


    @Override
    public List<Customer> findAll3() {
        return customerRepository.findAll();
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

    @Override
    public Page<Customer> findAll1(String nameVal, String areaVal, Pageable pageable) {
        return this.customerRepository.findAllByNameCustomerContainingAndAddressContaining(nameVal, areaVal, pageable);
    }

    @Override
    public Page<Customer> findAll2(String nameVal, String areaVal, int cusType, Pageable pageable) {
        return customerRepository.findAllByNameCustomerContainingAndAddressContainingAndCustomerType_Id
                (nameVal, areaVal, cusType, pageable);
    }

    @Override
    public Page<Booking> findBooking(Pageable pageable) {
        return this.customerRepository.findBooking(pageable);
    }
}
