package com.example.springjavafx.repositories;

import com.example.springjavafx.tests.collective.LFTs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LFTsRepository extends JpaRepository<LFTs, Long> {

}
