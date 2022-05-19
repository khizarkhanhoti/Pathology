package com.example.springjavafx.tests;

public class MP {
	public static final String NAME = "MP";
	private String result;

	public String getResult(){
		return result;
	}

	public void setResult(int result){
		switch (result){
			case 1:
				this.result = "NO MP SEEN BY ICT METHOD.";
				break;
			case 2:
				this.result = "MP was seen.";
		}
	}
}
