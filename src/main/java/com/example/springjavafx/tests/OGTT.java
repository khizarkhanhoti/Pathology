package com.example.springjavafx.tests;

import com.example.springjavafx.entities.RangeTest;

public class OGTT extends RangeTest {


	private String type;
	private String normalRange;
	private String time;

	public OGTT() {

	}

	public OGTT(String name, String category, String type,
				String normalRange, String time){
		super(name, category);
		this.type = type;
		this.normalRange = normalRange;
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNormalRange() {
		return normalRange;
	}

	public void setNormalRange(String normalRange) {
		this.normalRange = normalRange;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
