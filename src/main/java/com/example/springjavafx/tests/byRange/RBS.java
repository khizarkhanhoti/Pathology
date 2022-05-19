package com.example.springjavafx.tests.byRange;

public class RBS {
	public static final String NAME = "BLOOD GLUCOSE (R)";
	public static final String NORMAL_RANGE = "R 80---160 mg/dl\nF 60---110 mg/dl";
	private String result;

	public String getResult() {
		return result;
	}

	public void setNormal_range(String result) {
		this.result = result + " mg/dl";
	}
}
