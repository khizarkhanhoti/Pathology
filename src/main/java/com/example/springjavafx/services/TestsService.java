package com.example.springjavafx.services;

import com.example.springjavafx.entities.Tests;
import com.example.springjavafx.repositories.TestRepository;
import com.example.springjavafx.repositories.TestsRepository;
import com.example.springjavafx.tests.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestsService {
	
	private final TestsRepository testsRepository;
	private final TestRepository testRepository;
	
	@Autowired
	public TestsService(TestsRepository testsRepository, TestRepository testRepository){
		this.testsRepository = testsRepository;
		this.testRepository = testRepository;
	}
	
	public Tests add(String name){
		Test testRequired = testRepository.findByName(name);
		String name1 = testRequired.getName();
		String range = testRequired.getRange();
		System.out.println(name1);
		System.out.println(range);
		Tests testSaved = new Tests(name1, range);
		testsRepository.save(testSaved);
		return testSaved;
	}
	
	public Tests find(String name){
		Tests tests = testsRepository.findByName(name);
		return tests;
	}
}
