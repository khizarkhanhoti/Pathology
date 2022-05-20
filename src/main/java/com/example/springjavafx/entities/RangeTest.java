package com.example.springjavafx.entities;

import javax.persistence.*;

@Entity
public class RangeTest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	private String name;
	private String normalRange;
	private String result;
	
	public RangeTest() {
	}
	
	public RangeTest(String name, String normalRange) {
		this.name = name;
		this.normalRange = normalRange;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNormalRange() {
		return normalRange;
	}
	
	public void setNormalRange(String normalRange) {
		this.normalRange = normalRange;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
}
