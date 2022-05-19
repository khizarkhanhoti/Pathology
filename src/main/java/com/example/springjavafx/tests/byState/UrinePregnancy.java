package com.example.springjavafx.tests.byState;

public class UrinePregnancy {
	public static final String NAME = "URINE PREGNANCY";
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(int result) {
		switch (result){
			case 0:
				this.result = "NEGATIVE (-VE)";
				break;
			case 1:
				this.result = "POSITIVE (+VE)";
				break;
		}
	}
}
