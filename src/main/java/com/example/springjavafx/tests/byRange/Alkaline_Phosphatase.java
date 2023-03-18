package com.example.springjavafx.tests.byRange;

import javax.persistence.*;

@Entity
public class Alkaline_Phosphatase {
	public final String NAME = "ALKALINE PHOSPHATASE";
	public final String NORMAL_RANGE = "UP TO 306 U/L";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	private String result;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result + " U/L";
	}
	
	@Override
	public String toString() {
		return "Alkaline_Phosphatase{" +
				"NAME='" + NAME + '\'' +
				", NORMAL_RANGE='" + NORMAL_RANGE + '\'' +
				", id=" + id +
				", result='" + result + '\'' +
				'}';
	}
}
