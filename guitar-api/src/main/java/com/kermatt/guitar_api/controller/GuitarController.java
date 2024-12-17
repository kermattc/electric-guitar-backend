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
                return guitarService.searchGuitars(words);
            }
            else {
                return guitarService.getGuitars();
            }
    }
}



// @RequestMapping(path="api/v1/guitars", method = {RequestMethod.GET, RequestMethod.OPTIONS})
// @CrossOrigin(origins={"http://localhost:4200", "http://localhost"})
// @CrossOrigin(origins="*")
// @RequiredArgsConstructor
// @CrossOrigin(methods = {RequestMethod.OPTIONS, RequestMethod.DELETE, RequestMethod.GET, RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.POST}, origins = "*")
// @CrossOrigin(origins = "http://localhost:4200") // my global config wasn't working so adding this worked\
// @CrossOrigin(origins = {"http://guitar-site.s3-website.us-east-2.amazonaws.com", "http://localhost:4200"})

    // // @GetMapping("/{word}")
    // public List<Guitar> getGuitarsByDescription(
    //     @PathVariable(required = false) String word) {
    //         System.out.println("Received word: " + word);
    //         if (word == null || word.trim().isEmpty()) {
    //             return guitarService.getGuitars();
    //         }
    //         return guitarService.searchGuitars(word);
    // }