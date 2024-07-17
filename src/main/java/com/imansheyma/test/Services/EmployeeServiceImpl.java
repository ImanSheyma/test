package com.imansheyma.test.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.imansheyma.test.DAO.EmployeeRepository;
import com.imansheyma.test.Entities.Employee;
import com.imansheyma.test.exceptions.EmployeeNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> readAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee readById(Long id) {
        Optional<Employee> empOptional = employeeRepository.findById(id);
        Employee employee = empOptional.orElseThrow(() -> new EmployeeNotFoundException(id));
        return employee;
    }

}
