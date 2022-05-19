package com.example.springjavafx.tests.collective;

import com.example.springjavafx.tests.byRange.ALKALINE_PHOSPHATASE;
import com.example.springjavafx.tests.byRange.SGPT;
import com.example.springjavafx.tests.byRange.S_BILIRUBIN;

public class LFT {
	private S_BILIRUBIN sbr;
	private ALKALINE_PHOSPHATASE alp;
	private SGPT sgpt;

	public LFT() {
	}

	public LFT(S_BILIRUBIN sbr, ALKALINE_PHOSPHATASE alp, SGPT sgpt) {
		this.sbr = sbr;
		this.alp = alp;
		this.sgpt = sgpt;
	}

	public S_BILIRUBIN getSbr() {
		return sbr;
	}

	public ALKALINE_PHOSPHATASE getAlp() {
		return alp;
	}

	public SGPT getSgpt() {
		return sgpt;
	}
}
