package com.example.springjavafx.services;

import com.example.springjavafx.repositories.LFTsRepository;
import com.example.springjavafx.repositories.SGPTRepository;
import com.example.springjavafx.repositories.S_BilirubinRepository;
import com.example.springjavafx.tests.byRange.SGPT;
import com.example.springjavafx.tests.byRange.S_BILIRUBIN;
import com.example.springjavafx.tests.collective.LFTs;
import org.springframework.stereotype.Service;

@Service
public class LFTsService {
	
	private final S_BilirubinRepository s_bilirubinRepository;
	private final SGPTRepository sgptRepository;
	private final LFTsRepository lfTsRepository;
	
	public LFTsService(S_BilirubinRepository s_bilirubinRepository, SGPTRepository sgptRepository, LFTsRepository lfTsRepository) {
		this.s_bilirubinRepository = s_bilirubinRepository;
		this.sgptRepository = sgptRepository;
		this.lfTsRepository = lfTsRepository;
	}
	
	public LFTs add(){
		S_BILIRUBIN s_bilirubin = s_bilirubinRepository.save(new S_BILIRUBIN());
		SGPT sgpt = sgptRepository.save(new SGPT());
		LFTs lfTs = new LFTs(s_bilirubin, sgpt);
		lfTsRepository.save(lfTs);
		return lfTs;
		
	}
	
	public LFTs update(Long id, String sbrResult, String sgptResult){
		LFTs lfTs = lfTsRepository.findById(id).get();
		
		S_BILIRUBIN s_bilirubin = s_bilirubinRepository.findById(lfTs.getSbr().getId()).get();
		s_bilirubin.setResult(sbrResult);
		s_bilirubinRepository.save(s_bilirubin);
		
		SGPT sgpt = sgptRepository.findById(lfTs.getSgpt().getId()).get();
		sgpt.setResult(sgptResult);
		sgptRepository.save(sgpt);
		
		return lfTsRepository.findById(id).get();
	}
	
	public int getAmount(){
		LFTs lfTs = new LFTs();
		return lfTs.getAmount();
	}
}
