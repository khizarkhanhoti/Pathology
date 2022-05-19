package com.example.springjavafx.tests.byRange;

public class S_AMYLASE {
	public static final String NAME = "S.AMYLASE";
	public static final String NORMAL_RANGE = "UP TO 125 mg/dl";
	private String result;

	public String getResult() {
		return result;
	}

	public void setNormal_range(String result) {
		this.result = result + " mg/dl";
	}
}
