package com.example.springjavafx.tests.byRange;

public class TSH {
	public static final String NAME = "Thyroid Stimulating Hormone";
	public static final String NORMAL_RANGE = "0.3------5.6";
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result + " µIU/ML";
	}
}
