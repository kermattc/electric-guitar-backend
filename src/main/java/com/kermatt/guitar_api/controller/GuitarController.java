package com.kermatt.guitar_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.kermatt.guitar_api.entity.Guitar;
import com.kermatt.guitar_api.service.GuitarService;
import com.kermatt.guitar_api.repository.GuitarRepository;

@RestController
@RequestMapping(path="api/v1/guitars")
public class GuitarController {
    private final GuitarService guitarService;

    @Autowired
    public GuitarController(GuitarService guitarService) {
        this.guitarService = guitarService;
    }

    @GetMapping
    public List<Guitar> getGuitars() {
        return guitarService.getGuitars();
    }
}