package com.example.springjavafx.tests.byState;

public class HCV {
	public static final String NAME = "HCV AB";
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(int result) {
		switch (result){
			case 1:
				this.result = result + "NON REACTIVE (--ve)";
				break;
			case 2:
				this.result = result + "REACTIVE (++ve)";
				break;
		}
	}
}
