package com.example.springjavafx.entities;

import javax.persistence.*;

@Entity
public class Test {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	private String name;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Test(String name){
		this.name = name;
	}
	
	public Test() {
	
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Test{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
