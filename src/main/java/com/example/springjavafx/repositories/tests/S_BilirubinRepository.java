package com.example.springjavafx.repositories.tests;

import com.example.springjavafx.tests.byRange.S_BILIRUBIN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface S_BilirubinRepository extends JpaRepository<S_BILIRUBIN, Long> {

}
