package com.exercise.service.employee;


import com.exercise.model.empolyee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {

    Page<Employee> findAll(Pageable pageable);

    void save(Employee employee);

    Employee findById(int id);

    void update(Employee employee);

    void remove(Employee employee);
}
