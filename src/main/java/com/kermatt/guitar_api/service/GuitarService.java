package com.kermatt.guitar_api.service;

import org.springframework.stereotype.Component;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import com.kermatt.guitar_api.repository.GuitarRepository;
import com.kermatt.guitar_api.entity.Guitar;

@Component
public class GuitarService {
    private final GuitarRepository guitarRepository;

    @Autowired
    public GuitarService(GuitarRepository guitarRepository) {
        this.guitarRepository = guitarRepository;
    }

    // return all rows
    public List<Guitar> getGuitars() {
        return guitarRepository.findAll();
    }
}