package com.example.springjavafx.tests;

public class HBA1C {
	public static final String NAME = "HBA1C";
	public static final String NON_DIABETIC_LEVEL = "4.2-------6.2 %";
	public static final String GOOD_CONTROL = "5.5 ----- 6.8 %";
	public static final String FAIR = "6.8-------7.6 %";
	public static final String VERY_POOR_CONTROL = "> 7.6 %";
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result + "%";
	}

}
