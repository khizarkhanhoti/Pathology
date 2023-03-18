package com.example.springjavafx.tests.byRange;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
public class S_BILIRUBIN{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	public final String NAME = "S.BILIRUBIN";
	public final String NORMAL_RANGE = "0.4---1.2 mg/dl";
	
	private String result;
	
	public void setId(Long id) {
		if (id == null) {
			this.id = id;
		}
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
