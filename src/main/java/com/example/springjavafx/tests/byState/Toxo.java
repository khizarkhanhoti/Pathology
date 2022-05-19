package com.example.springjavafx.tests.byState;

public class Toxo {
	public static final String NAME = "TOXO";
	public static final String IgM = "Toxoplasmosis IgM";
	public static final String IgG = "Toxoplasmosis IgM";
	public String IgMValue;
	public String IgGValue;

	public String getIgMValue() {
		return IgMValue;
	}

	public void setIgMValue(int igMValue) {
		switch (igMValue){
			case 0:
				this.IgMValue = "NEGATIVE (-ve)";
				break;
			case 1:
				this.IgMValue = "POSITIVE (+ve)";
		}
	}

	public String getIgGValue() {
		return IgGValue;
	}

	public void setIgGValue(int igGValue) {
		switch (igGValue){
			case 0:
				this.IgGValue = "NEGATIVE (-ve)";
				break;
			case 1:
				this.IgGValue = "POSITIVE (+ve)";
		}
	}
}
