package com.kermatt.guitar_api.repository;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.stereotype.Repository;

import com.kermatt.guitar_api.entity.Guitar;


// get CRUD operations from JPA as well as any data access logic (interacting with db)
// extending jpa repository gives access to a bunch of methods for interacting with data
public interface GuitarRepository extends JpaRepository<Guitar, Integer>, JpaSpecificationExecutor<Guitar> {

    // using findBy (which indicates a query) would result in a verryy long function name (findByMakerIgnoreCaseContainingOrModelIgnoreCaseContaining....OrFinish3IgnoreContaining(String keyword);)
        // since that's the case it's better to use a query
    // @Query("SELECT g FROM Guitar g WHERE " +
    // "LOWER(g.maker) LIKE %:keyword% OR " +
    // "LOWER(g.model) LIKE %:keyword% OR " +
    // "LOWER(g.notableUser1) LIKE %:keyword% OR " +
    // "LOWER(g.notableUser2) LIKE %:keyword% OR " +
    // "LOWER(g.notableUser3) LIKE %:keyword% OR " +
    // "LOWER(g.feature1) LIKE %:keyword% OR " +
    // "LOWER(g.feature2) LIKE %:keyword% OR " +
    // "LOWER(g.feature3) LIKE %:keyword% OR " +
    // "LOWER(g.feature4) LIKE %:keyword% OR " +
    // "LOWER(g.feature5) LIKE %:keyword% OR " +
    // "LOWER(g.popularity) LIKE %:keyword%")

    // @Query("SELECT g FROM Guitar g WHERE " +
    // "(LOWER(g.maker) LIKE %:keyword% OR " +
    // "LOWER(g.model) LIKE %:keyword% OR " +
    // "LOWER(g.notableUser1) LIKE %:keyword% OR " +
    // "LOWER(g.notableUser2) LIKE %:keyword% OR " +
    // "LOWER(g.notableUser3) LIKE %:keyword% OR " +
    // "LOWER(g.feature1) LIKE %:keyword% OR " +
    // "LOWER(g.feature2) LIKE %:keyword% OR " +
    // "LOWER(g.feature3) LIKE %:keyword% OR " +
    // "LOWER(g.feature4) LIKE %:keyword% OR " +
    // "LOWER(g.feature5) LIKE %:keyword% OR " +
    // "LOWER(g.popularity) LIKE %:keyword%)")
    // List<Guitar> searchGuitarsByKeywords(@Param("keyword") String keywords);

    // @Query("SELECT g FROM Guitar g WHERE " + 
    // "LOWER(g.maker) LIKE LOWER(:keyword) OR " + 
    // "LOWER(g.model) LIKE LOWER(:keyword) OR " + 
    // "LOWER(g.notableUser1) LIKE LOWER(:keyword) OR " + 
    // "LOWER(g.notableUser2) LIKE LOWER(:keyword) OR " + 
    // "LOWER(g.notableUser3) LIKE LOWER(:keyword) OR " + 
    // "LOWER(g.feature1) LIKE LOWER(:keyword) OR " + 
    // "LOWER(g.feature2) LIKE LOWER(:keyword) OR " + 
    // "LOWER(g.feature3) LIKE LOWER(:keyword) OR " + 
    // "LOWER(g.feature4) LIKE LOWER(:keyword) OR " + 
    // "LOWER(g.feature5) LIKE LOWER(:keyword) OR " + 
    // "LOWER(g.popularity) LIKE LOWER(:keyword)")
    // List<Guitar> searchGuitarsByKeywords(@Param("keyword") String keyword);
    
}