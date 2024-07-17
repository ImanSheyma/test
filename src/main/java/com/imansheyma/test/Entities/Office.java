package com.imansheyma.test.Entities;

import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
@DynamicUpdate
public class Office {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String country;
    private String city;
    private String address;
    @JsonIgnore
    @OneToMany(mappedBy="office", cascade=CascadeType.ALL)
    private List<Employee> employees;
}
