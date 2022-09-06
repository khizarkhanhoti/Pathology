package com.example.springjavafx.repositories.tests;

import com.example.springjavafx.tests.byRange.S_CHOLESTEROL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface S_CholesterolRepository extends JpaRepository<S_CHOLESTEROL, Long> {
}
