package com.example.springjavafx.tests.byState;

public class TYPHIDOT {

	private static final String typhidot_g = "Typhidot Ig M";
	private static final String typhidot_m = "Typhidot Ig M";
	private String gValue;
	private String mValue;

	public String getgValue() {
		return gValue;
	}

	public void setgValue(int i) {
		switch (i){
			case 0:
				this.gValue = "POSITIVE ( + VE )";
				break;
			case 1:
				this.gValue = "Negative ( + VE )";
		}

	}

	public String getGValue() {
		return mValue;
	}

	public void setMValue(int i) {
		switch (i){
			case 0:
				this.mValue = "POSITIVE ( + VE )";
				break;
			case 1:
				this.mValue = "Negative ( + VE )";
		}
	}
}
