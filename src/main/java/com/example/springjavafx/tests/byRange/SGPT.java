package com.example.springjavafx.tests.byRange;

import javax.persistence.*;

@Entity
public class SGPT {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	public final String NAME = "SGPT(ALT)";
	public final String NORMAL_RANGE = "UP TO 40 U/L";
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
		return "SGPT{" +
				"id=" + id +
				", NAME='" + NAME + '\'' +
				", NORMAL_RANGE='" + NORMAL_RANGE + '\'' +
				", result='" + result + '\'' +
				'}';
	}
}
