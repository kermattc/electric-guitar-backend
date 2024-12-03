package com.kermatt.guitar_api.service;

import org.springframework.stereotype.Component;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.ArrayList;
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

    // return guitars by list of keywords using anyMatch
    // goes like this:
        // 1) Get all the descriptions via findAll().stream(). Then filter out descriptions with the following conditions:
        // 2) for each description, check if any of the keywords match. If yes, return true
    public List<Guitar> searchGuitars(List<String> keywords) {
        return guitarRepository.findAll().stream()
            .filter(guitar -> {
                String description = guitar.getPopularity();
                return keywords.stream().anyMatch(
                    keyword -> description.toLowerCase().contains(keyword));
            })
           .collect(Collectors.toList());
    }
}