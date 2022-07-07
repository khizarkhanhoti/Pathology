package com.example.springjavafx.tests;

import javax.persistence.*;

@Entity
public class Test {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	private String name;
	private String range;
	private String result;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Test(String name, String range, String result){
		this.name = name;
		this.range = range;
		this.result = result;
	}
	
	public Test(String name, String result){
		this.name = name;
		this.result = result;
	}
	
	public Test() {
	
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRange() {
		return range;
	}
	
	public void setRange(String range) {
		this.range = range;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	@Override
	public String toString() {
		return "Test{" +
				"id=" + id +
				", name='" + name + '\'' +
				", range='" + range + '\'' +
				", result='" + result + '\'' +
				'}';
	}
}
