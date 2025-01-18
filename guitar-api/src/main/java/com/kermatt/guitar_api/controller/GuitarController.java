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
public class GuitarController {
    private final GuitarService guitarService;

    @Autowired
    public GuitarController(GuitarService guitarService) {
        this.guitarService = guitarService;
    }

    // search list of guitars. Adds keywords in there to refine search
    @CrossOrigin(origins={"https://d3v8d7zaba9elv.cloudfront.net", "http://localhost:4200"})
    @GetMapping("/api/v1/guitars")
    public List<Guitar> getGuitars(
        @RequestParam(required = false) List<String> words) {
            if (words != null) {
                // List<String> keywords = List.of(words.split(","));
                // System.out.println("From controller - words: " + words);
                // try {
                //     Thread.sleep(6000);
                // } catch (InterruptedException e) {
                //     e.printStackTrace();
                // }
                return guitarService.searchGuitars(words);
            }
            else {
                return guitarService.getGuitars();
            }
    }
}