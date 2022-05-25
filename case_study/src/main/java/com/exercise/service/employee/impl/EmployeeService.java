package com.exercise.service.employee.impl;

import com.exercise.model.empolyee.Employee;
import com.exercise.repository.employee.IEmployeeRepository;
import com.exercise.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return this.employeeRepository.findAll(pageable);
    }

    @Override
    public List<Employee> findAll2() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> findAllAndSearchName(String name, Pageable pageable) {
        return employeeRepository.findAllByNameEmployeeContaining(name, pageable);
    }

    @Override
    public Page<Employee> findAllAndSearch(String name, int position, int division, int education, Pageable pageable) {
        return employeeRepository.findAllByNameEmployeeContainingAndPositionAndDivisionAndEducationDegree
                (name, position, division, education, pageable);
    }

    @Override
    public void save(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return this.employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public void remove(Employee employee) {
        this.employeeRepository.delete(employee);
    }
}
