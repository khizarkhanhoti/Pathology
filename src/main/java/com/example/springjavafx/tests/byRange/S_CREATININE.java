package com.example.springjavafx.tests.byRange;

public class S_CREATININE {
	public static final String NAME = "S.CREATININE";
	public static final String NORMAL_RANGE = "0.6 – 1.2 mg/dl";
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result + " mg/dl";
	}
}
