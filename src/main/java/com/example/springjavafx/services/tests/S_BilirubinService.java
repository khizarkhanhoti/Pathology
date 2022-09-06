package com.example.springjavafx.services.tests;

import com.example.springjavafx.repositories.tests.S_BilirubinRepository;
import com.example.springjavafx.tests.byRange.S_BILIRUBIN;
import com.example.springjavafx.tests.byRange.S_CHOLESTEROL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S_BilirubinService {
	@Autowired
	private S_BilirubinRepository s_bilirubinRepository;
	
	public S_BILIRUBIN add(S_BILIRUBIN s_bilirubin){
		return s_bilirubinRepository.save(s_bilirubin);
	}
	
	public void update(S_BILIRUBIN s_bilirubin){
		String result = s_bilirubin.getResult();
		Long id = s_bilirubin.getId();
		s_bilirubinRepository.findById(id).get().setResult(result);
		
	}
}
