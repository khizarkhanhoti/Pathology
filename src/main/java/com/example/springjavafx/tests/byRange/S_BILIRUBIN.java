package com.example.springjavafx.tests.byRange;

import javax.persistence.*;

@Entity
public class S_BILIRUBIN {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	public final String NAME = "S.BILIRUBIN";
	public final String NORMAL_RANGE = "0.4---1.2 mg/dl";
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
		this.result = result + " mg/dl";
	}
	
	@Override
	public String toString() {
		return "S_BILIRUBIN{" +
				"id=" + id +
				", NAME='" + NAME + '\'' +
				", NORMAL_RANGE='" + NORMAL_RANGE + '\'' +
				", result='" + result + '\'' +
				'}';
	}
}
