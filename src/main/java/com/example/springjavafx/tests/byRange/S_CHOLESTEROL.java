package com.example.springjavafx.tests.byRange;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class S_CHOLESTEROL {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	public final String NAME = "S.CHOLESTEROL";
	public final String NORMAL_RANGE = "100------200 mg/dl";
	public final int price = 400;
	private String result;
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setResult(String result) {
		this.result = result + " mg/dl";
	}
	
}
