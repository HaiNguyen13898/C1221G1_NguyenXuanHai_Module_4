package com.exercise.service.customer;

import com.exercise.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll3();

    void save(Customer customer);

    Customer findById(int id);

    void update(Customer customer);

    void remove(Customer customer);

    Page<Customer> findAll1(String nameVal, String areaVal, Pageable pageable);

    Page<Customer> findAll2(String nameVal, String areaVal, int cusType, Pageable pageable);
}
