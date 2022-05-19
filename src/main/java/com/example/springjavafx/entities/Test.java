package com.example.springjavafx.entities;

public class Test {

	private String name;
	private String category;

	public Test() {
	}

	public Test(String name, String category) {
		this.name = name;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void thisISTest(){
		System.out.println("this is test");
	}
}
