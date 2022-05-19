package com.example.springjavafx.tests.byRange;

public class S_BILIRUBIN {

	public static final String NAME = "S.BILIRUBIN";
	public static final String NORMAL_RANGE = "0.4---1.2 mg/dl";
	private String result;

	public String getResult() {
		return result;
	}

	public void setNormal_range(String result) {
		this.result = result + " mg/dl";
	}
}
