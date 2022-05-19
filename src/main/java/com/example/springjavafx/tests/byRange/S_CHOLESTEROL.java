package com.example.springjavafx.tests.byRange;

public class S_CHOLESTEROL {
	public static final String NAME = "S.CHOLESTEROL";
	public static final String NORMAL_RANGE = "100------200 mg/dl";
	private String result;

	public String getResult() {
		return result;
	}

	public void setNormal_range(String result) {
		this.result = result + " mg/dl";
	}
}
