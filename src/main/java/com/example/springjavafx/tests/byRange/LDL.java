package com.example.springjavafx.tests.byRange;

public class LDL {
	public static final String NAME = "LDL";
	public static final String NORMAL_RANGE = "UP TO 150 mg/dl";
	private String result;

	public String getResult() {
		return result;
	}

	public void setNormal_range(String result) {
		this.result = result + " mg/dl";
	}
}
