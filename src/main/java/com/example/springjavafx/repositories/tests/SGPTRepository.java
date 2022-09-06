package com.example.springjavafx.repositories.tests;

import com.example.springjavafx.tests.byRange.SGPT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SGPTRepository extends JpaRepository<SGPT, Long> {
}
