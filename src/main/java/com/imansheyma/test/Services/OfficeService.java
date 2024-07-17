package com.imansheyma.test.Services;

import java.util.List;

import com.imansheyma.test.Entities.Office;

public interface OfficeService {
    public Office save(Office office);
    public void delete(Long id);
    public List<Office> readAll();
    public Office readById(Long id);
}
