package com.example.springjavafx.reports;

import lombok.Data;

@Data
public class BloodGlucose {

	private String name = "Blood Glucose";
	private String normalRange = "R 80---160 mg/dl \nF 60---110 mg/dl";
	private int result;
}
