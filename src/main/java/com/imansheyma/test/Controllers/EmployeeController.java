package com.imansheyma.test.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imansheyma.test.Entities.Employee;
import com.imansheyma.test.Services.EmployeeService;
import com.imansheyma.test.exceptions.EmployeeNotFoundException;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    
    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<> (employeeService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/office/{office_id}")
    public ResponseEntity<List<Employee>> getAllEmployeesByOfficeId(@PathVariable("office_id") Long officeId){
        return new ResponseEntity<> (employeeService.readAllByOfficeId(officeId), HttpStatus.OK);
    }


    @GetMapping("/{id}") 
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        return new ResponseEntity<>(employeeService.readById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return new ResponseEntity<> (employeeService.save(employee), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return  new ResponseEntity<>(employeeService.save(employee), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployees(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> handle_Office_Not_Found_Exception(EmployeeNotFoundException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
}
