package com.example.springjavafx.services.tests;

import com.example.springjavafx.repositories.tests.Alkaline_PhosphataseRepository;
import com.example.springjavafx.repositories.tests.LFTsRepository;
import com.example.springjavafx.repositories.tests.SGPTRepository;
import com.example.springjavafx.repositories.tests.S_BilirubinRepository;
import com.example.springjavafx.tests.byRange.Alkaline_Phosphatase;
import com.example.springjavafx.tests.byRange.SGPT;
import com.example.springjavafx.tests.byRange.S_BILIRUBIN;
import com.example.springjavafx.tests.collective.LFTs;
import org.springframework.stereotype.Service;

@Service
public class LFTsService {
	
	private final S_BilirubinRepository s_bilirubinRepository;
	private final SGPTRepository sgptRepository;
	private final Alkaline_PhosphataseRepository alkaline_phosphataseRepository;
	private final LFTsRepository lfTsRepository;
	
	public LFTsService(S_BilirubinRepository s_bilirubinRepository, SGPTRepository sgptRepository, Alkaline_PhosphataseRepository alkaline_phosphataseRepository, LFTsRepository lfTsRepository) {
		this.s_bilirubinRepository = s_bilirubinRepository;
		this.sgptRepository = sgptRepository;
		this.alkaline_phosphataseRepository = alkaline_phosphataseRepository;
		this.lfTsRepository = lfTsRepository;
	}
	
	public LFTs add(){
		S_BILIRUBIN s_bilirubin = s_bilirubinRepository.save(new S_BILIRUBIN());
		SGPT sgpt = sgptRepository.save(new SGPT());
		Alkaline_Phosphatase alkaline_phosphatase = alkaline_phosphataseRepository.save(new Alkaline_Phosphatase());
		LFTs lfTs = new LFTs(s_bilirubin, sgpt, alkaline_phosphatase);
		lfTsRepository.save(lfTs);
		return lfTs;
		
	}
	
	public LFTs update(Long id, String sbrResult, String sgptResult, String alkaline_phosphataseResult){
		LFTs lfTs = lfTsRepository.findById(id).get();
		
		S_BILIRUBIN s_bilirubin = s_bilirubinRepository.findById(lfTs.getSbr().getId()).get();
		s_bilirubin.setResult(sbrResult);
		s_bilirubinRepository.save(s_bilirubin);
		
		SGPT sgpt = sgptRepository.findById(lfTs.getSgpt().getId()).get();
		sgpt.setResult(sgptResult);
		sgptRepository.save(sgpt);
		
		Alkaline_Phosphatase alkaline_phosphatase = alkaline_phosphataseRepository.findById(lfTs.getAlkaline_phosphatase().getId()).get();
		alkaline_phosphatase.setResult(alkaline_phosphataseResult);
		alkaline_phosphataseRepository.save(alkaline_phosphatase);
		
		return lfTsRepository.findById(id).get();
	}
	
	public int getAmount(){
		LFTs lfTs = new LFTs();
		return lfTs.getAmount();
	}
}
