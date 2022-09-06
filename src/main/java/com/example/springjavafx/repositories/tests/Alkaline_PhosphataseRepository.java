package com.example.springjavafx.repositories.tests;

import com.example.springjavafx.tests.byRange.Alkaline_Phosphatase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Alkaline_PhosphataseRepository extends JpaRepository<Alkaline_Phosphatase, Long> {
}
