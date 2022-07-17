package com.example.springjavafx.repositories;

import com.example.springjavafx.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query
	User findByNameAndPassword(String name, String password);

}
