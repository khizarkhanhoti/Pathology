package com.example.springjavafx.tests.byRange;

public class ClottingTime {
	public static final String NAME = "CLOTTING TIME";
	public static final String NORMAL_RANGE = "05--11 MIN";
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(int mm, int ss) {
		this.result = mm + " MIN " + ss + " SEC";
	}
}
