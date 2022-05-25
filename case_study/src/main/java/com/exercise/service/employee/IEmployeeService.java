package com.exercise.service.employee;


import com.exercise.model.empolyee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {

    Page<Employee> findAll(Pageable pageable);

    List<Employee> findAll2();

    Page<Employee> findAllAndSearchName(String name, Pageable pageable);

    Page<Employee> findAllAndSearch
            (String name, int position, int division, int education, Pageable pageable);

    void save(Employee employee);

    Employee findById(int id);

    void update(Employee employee);

    void remove(Employee employee);
}
