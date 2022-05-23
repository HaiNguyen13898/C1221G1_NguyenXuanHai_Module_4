package com.exercise.service.customer;

import com.exercise.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {

    Page<Customer> findAllAndSearch (String name, String address, String phone, Pageable pageable);

    void save(Customer customer);

    Customer findById(int id);

    void update(Customer customer);

    void remove(Customer customer);
}
