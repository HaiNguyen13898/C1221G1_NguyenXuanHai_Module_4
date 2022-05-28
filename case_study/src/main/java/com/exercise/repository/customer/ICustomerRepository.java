package com.exercise.repository.customer;

import com.exercise.dto.Booking;
import com.exercise.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAllByNameCustomerContainingAndAddressContainingAndCustomerType_Id
            (String name, String address, int cusType, Pageable pageable);

    Page<Customer> findAllByNameCustomerContainingAndAddressContaining
            (String name, String address, Pageable pageable);

    @Query(value="select name_customer as `nameCustomer`, en_day as `enDay` , start_day as `starDay`, group_concat(name_attach_service) as `attachService`, sum(service.sv_cost+(contract_detail.quantity*attach_service.cost)) as `total` from customer  join contract on customer.id_customer = contract.id_customer\n" +
            "left join contract_detail on contract.id_contract  = contract_detail.id_contract left join attach_service on attach_service.id = contract_detail.id_attch_service \n" +
            "join service on service.id= contract.id_service\n" +
            "group by contract.id_contract",
    countQuery = "select name_customer as `nameCustomer`, en_day as `enDay` , start_day as `starDay`, group_concat(name_attach_service) as `attachService`, sum(service.sv_cost+(contract_detail.quantity*attach_service.cost)) as `total` from customer  join contract on customer.id_customer = contract.id_customer\n" +
            "left join contract_detail on contract.id_contract  = contract_detail.id_contract left join attach_service on attach_service.id = contract_detail.id_attch_service \n" +
            "join service on service.id= contract.id_service\n" +
            "group by contract.id_contract",
            nativeQuery = true)
    Page<Booking> findBooking(Pageable pageable);
}
