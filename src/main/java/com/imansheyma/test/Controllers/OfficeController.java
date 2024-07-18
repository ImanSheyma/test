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

import com.imansheyma.test.Entities.Office;
import com.imansheyma.test.Services.OfficeService;
import com.imansheyma.test.exceptions.OfficeNotFoundException;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/office")
public class OfficeController {
    private final OfficeService officeService;
    
    @GetMapping("/")
    public ResponseEntity<List<Office>> getAllOfficies(){
        return new ResponseEntity<> (officeService.readAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}") 
    public ResponseEntity<Office> getOfficeById(@PathVariable("id") Long id){
        return new ResponseEntity<>(officeService.readById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Office> addOffice(@RequestBody Office office){
        return new ResponseEntity<> (officeService.save(office), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Office> updateOfficies(@RequestBody Office office) {
        return new ResponseEntity<> (officeService.save(office), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOfficies(@PathVariable Long id) {
        officeService.delete(id);
        return ResponseEntity.ok("");
    }

    @ExceptionHandler(OfficeNotFoundException.class)
    public ResponseEntity<String> handle_Office_Not_Found_Exception(OfficeNotFoundException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
}
