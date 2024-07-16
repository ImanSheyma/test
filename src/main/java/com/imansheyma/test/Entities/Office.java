package com.imansheyma.test.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Office {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String country;
    private String city;
    private String address;
    @OneToMany(mappedBy="office", cascade=CascadeType.REMOVE)
    private List<Employee> employees;
}
