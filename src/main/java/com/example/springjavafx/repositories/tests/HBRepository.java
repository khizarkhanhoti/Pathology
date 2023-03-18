package com.example.springjavafx.repositories.tests;

import com.example.springjavafx.tests.byRange.HB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HBRepository extends JpaRepository<HB, Long> {
}
