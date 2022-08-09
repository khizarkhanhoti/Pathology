package com.example.springjavafx.repositories;

import com.example.springjavafx.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
	
	@Query
	Test findByName(String name);
}
