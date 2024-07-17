package com.imansheyma.test.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.imansheyma.test.DAO.OfficeRepository;
import com.imansheyma.test.Entities.Office;
import com.imansheyma.test.exceptions.OfficeNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OfficeServiceImpl implements OfficeService{
    private final OfficeRepository officeRepository;

    @Override
    public Office save(Office officies) {
        return officeRepository.save(officies);
    }

    @Override
    public void delete(Long id) {
        officeRepository.deleteById(id);
    }

    @Override
    public List<Office> readAll() {
        return officeRepository.findAll();
    }

    @Override
    public Office readById(Long id) {
        Optional<Office> officeOptional = officeRepository.findById(id);
        Office office = officeOptional.orElseThrow(() -> new OfficeNotFoundException(id));
        return office;
    }
}
