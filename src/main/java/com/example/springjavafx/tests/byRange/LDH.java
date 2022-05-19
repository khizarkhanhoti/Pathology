package com.example.springjavafx.tests.byRange;

public class LDH {
	public static final String NAME = "LDH";
	public static final String NORMAL_RANGE = "120--250 mg/dl";
	private String result;

	public String getResult() {
		return result;
	}

	public void setNormal_range(String result) {
		this.result = result + " mg/dl";
	}
}
