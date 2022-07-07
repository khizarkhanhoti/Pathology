package com.example.springjavafx.repositories;

import com.example.springjavafx.entities.RangeTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RangeTestRepository extends JpaRepository<RangeTest, Long> {

}
