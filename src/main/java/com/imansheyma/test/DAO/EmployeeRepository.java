package com.imansheyma.test.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imansheyma.test.Entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    public List<Employee> findAllByOfficeId(Long id);
}
