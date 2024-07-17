package com.imansheyma.test.Services;

import java.util.List;

import com.imansheyma.test.Entities.Employee;

public interface EmployeeService {
    public Employee save(Employee employee);
    public void delete(Long id);
    public List<Employee> readAll();
    public Employee readById(Long id);
}
