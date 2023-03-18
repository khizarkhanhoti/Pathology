package com.example.springjavafx.repositories;

import com.example.springjavafx.entities.Tests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TestsRepository extends JpaRepository<Tests, Long> {
    @Query
    Tests findByName(String name);
}
