package com.example.springjavafx.services;

import com.example.springjavafx.entities.Test;
import com.example.springjavafx.entities.Tests;
import com.example.springjavafx.repositories.TestRepository;
import com.example.springjavafx.repositories.TestsRepository;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	private final TestRepository testRepository;
	private final TestsRepository testsRepository;

	public TestService(TestRepository testRepository, TestsRepository testsRepository) {
		this.testRepository = testRepository;
		this.testsRepository = testsRepository;
	}

	public Test add(String name){
		Tests tests = testsRepository.findByName(name);
		Test test = new Test();
		test.setName(tests.getName());
		testRepository.save(test);
		return test;
	}

	public void update(Long id, String result){
		Test test = testRepository.findById(id).get();
		test.setResult(result);
		testRepository.save(test);
	}
}
