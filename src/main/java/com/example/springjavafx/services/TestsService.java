package com.example.springjavafx.services;

import com.example.springjavafx.entities.Tests;
import com.example.springjavafx.repositories.TestsRepository;
import com.example.springjavafx.services.tests.LFTsService;
import com.example.springjavafx.tests.collective.LFTs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestsService {
	
	@Autowired
	private  TestsRepository testsRepository;
	
	@Autowired
	private LFTsService lfTsService;
	
	
	public Tests add(String name){
		Tests tests = new Tests();
		System.out.println(name);
		switch (name){
			case "LFTs":
				System.out.println("inside");
				LFTs lfTs = lfTsService.add();
				tests.setLfTs(lfTs);
				tests.setAmount(lfTs.getAmount());
				break;
		}
		
		testsRepository.save(tests);
		return tests;
	}
	
	public int getAmount(String test){
		if (test != null) {
			int amount = 0;
			switch (test) {
				case "LFTs":
					amount = lfTsService.getAmount();
					break;
			}
			return amount;
		}
		return 0;
	}
}
