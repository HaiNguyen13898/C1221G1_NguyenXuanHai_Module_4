package com.exercise.repository.customer;

import com.exercise.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAllByNameCustomerContainingAndAddressContainingAndCustomerType_Id
            (String name, String address, int cusType, Pageable pageable);

    Page<Customer> findAllByNameCustomerContainingAndAddressContaining
            (String name, String address, Pageable pageable);

}
