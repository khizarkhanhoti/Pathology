package com.example.springjavafx.tests.byRange;

public class HDL {
	public static final String NAME = "HDL";
	public static final String NORMAL_RANGE = "35-------65 mg/dl";
	private String result;

	public String getResult() {
		return result;
	}

	public void setNormal_range(String result) {
		this.result = result + " mg/dl";
	}
}
