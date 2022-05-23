package com.exercise.repository.customer;

import com.exercise.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAllByNameCustomerContainingAndAddressContainingAndPhoneNumberContaining
            (String name, String address, String phone, Pageable pageable);

}
