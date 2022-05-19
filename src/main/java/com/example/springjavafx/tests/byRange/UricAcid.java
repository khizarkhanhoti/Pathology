package com.example.springjavafx.tests.byRange;

public class UricAcid {
	public static final String NAME = "URIC ACID";
	public static final String NORMAL_RANGE = "(M 3.4----7.0 mg/dl)\n(F 2.4----5.7 mg/dl)";
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result + " mg/dl";
	}
}
