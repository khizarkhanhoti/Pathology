package com.example.springjavafx.entities;

import javax.persistence.*;

@Entity
public class Tests {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	private String name;
	private String normal_range;
	private String result;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Tests(){
	
	}
	
	public Tests(String name, String normal_range){
		this.name = name;
		this.normal_range = normal_range;
		this.result = "result";
	}
	
	public Tests(String name, String normal_range, String result){
		this.name = name;
		this.normal_range = normal_range;
		this.result = result;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNormal_range(String range) {
		this.normal_range = range;
	}
	
	public String getNormal_range(){
		return normal_range;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
