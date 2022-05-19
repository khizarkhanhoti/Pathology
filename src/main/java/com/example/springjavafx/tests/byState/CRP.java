package com.example.springjavafx.tests.byState;

public class CRP {
	public static final String NAME = "CRP";
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(int result) {
		switch (result){
			case 1:
				this.result = result + "NEGATIVE (--ve)";
				break;
			case 2:
				this.result = result + "POSITIVE (++ve)";
				break;
		}
	}
}
