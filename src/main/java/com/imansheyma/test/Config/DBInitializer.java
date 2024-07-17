package com.imansheyma.test.Config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imansheyma.test.DAO.EmployeeRepository;
import com.imansheyma.test.DAO.OfficeRepository;
import com.imansheyma.test.Entities.Employee;
import com.imansheyma.test.Entities.Office;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DBInitializer implements CommandLineRunner{
    @Value("${office}")
    private String config_office;

    @Value("${employees}")
    private String config_employees;


    private final OfficeRepository officeRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Office office = mapper.readValue(config_office, Office.class);
        List<Employee> employees = mapper.readValue(config_employees, new TypeReference<List<Employee>>() {});
        
        for(Employee employee: employees)
            employee.setOffice(office);

        officeRepository.save(office);
        employeeRepository.saveAll(employees);
    }

}
