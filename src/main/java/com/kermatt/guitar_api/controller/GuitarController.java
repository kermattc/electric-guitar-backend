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

    // search list of guitars. Adds keywords in there to refine search
    @GetMapping
    public List<Guitar> getGuitars(
        @RequestParam(required = false) String word) {
            if (word != null) {
                return guitarService.searchGuitars(word);
            }
            else {
                return guitarService.getGuitars();
            }
    }
    
    // // @GetMapping("/{word}")
    // public List<Guitar> getGuitarsByDescription(
    //     @PathVariable(required = false) String word) {
    //         System.out.println("Received word: " + word);
    //         if (word == null || word.trim().isEmpty()) {
    //             return guitarService.getGuitars();
    //         }
    //         return guitarService.searchGuitars(word);
    // }
}
