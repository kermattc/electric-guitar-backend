package com.kermatt.guitar_api.repository;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kermatt.guitar_api.entity.Guitar;

// get CRUD operations from JPA as well as any data access logic (interacting with db)
// extending jpa repository gives access to a bunch of methods for interacting with data
public interface GuitarRepository extends JpaRepository<Guitar, Integer> {

}