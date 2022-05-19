package com.example.springjavafx.tests.byRange;

public class S_CHLORIDE {
	public static final String NAME = "S.CHLORIDE (CL)";
	public static final String NORMAL_RANGE = "96-------108";
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result + " nmol/L";
	}
}
