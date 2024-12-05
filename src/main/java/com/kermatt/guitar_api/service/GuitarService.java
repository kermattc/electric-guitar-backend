package com.kermatt.guitar_api.service;

import org.springframework.stereotype.Component;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
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

    // ye old inefficient method
    // return guitars by list of keywords using anyMatch
    // goes like this:
        // 1) get all the rows in the db. for each row, get the data specified by the attributes. filter out nulls and turn them into lower case
        // 2) check if any of the strings contain any of the keywords. If they do, return true, which will return that row
    // public List<Guitar> searchGuitars(List<String> keywords) {
    //     // turn keywords to lower case
    //     List<String> lowerCaseKeywords = keywords.stream()
    //         .map(String::toLowerCase)
    //         .collect(Collectors.toList());
    
    //     // Perform search
    //     return guitarRepository.findAll().stream()
    //         .filter(guitar -> {
    //             // Collect all attributes into a list. filter out nulls and turn them to lower case
    //             List<String> attributes = Stream.of(
    //                 guitar.getMaker(),
    //                 guitar.getModel(),
    //                 guitar.getNotableUser1(),
    //                 guitar.getNotableUser2(),
    //                 guitar.getNotableUser3(),
    //                 guitar.getFeature1(),
    //                 guitar.getFeature2(),
    //                 guitar.getFeature3(),
    //                 guitar.getFeature4(),
    //                 guitar.getFeature5(),
    //                 guitar.getPopularity(),
    //                 guitar.getFinish1(),
    //                 guitar.getFinish2(),
    //                 guitar.getFinish3()
    //             )
    //             .filter(attr -> attr != null)
    //             .map(String::toLowerCase)
    //             .collect(Collectors.toList());
    
    //         // check if this row has any of the keywords. if it does, return true
    //         return lowerCaseKeywords.stream().anyMatch(
    //             keyword -> attributes.stream().anyMatch(attr -> attr.contains(keyword))
    //         );
    //     })
    //     .collect(Collectors.toList());
    // }


    // new! and improved! search method. loop through words array and perform query search
    // TODO - modify so that it doesn't repeat search of previous keyword, only new ones
    public List<Guitar> searchGuitars(List<String> keywords) {
    
        List<Guitar> results = new ArrayList<>();

        for (String keyword: keywords){
            // System.out.println("Searching columns that have this word: " + keyword);
            results.addAll(guitarRepository.searchGuitarsByKeyword(keyword.toLowerCase()));
        }

        // remove duplicates
        return results.stream().distinct().collect(Collectors.toList());
        // return results;

    }
}