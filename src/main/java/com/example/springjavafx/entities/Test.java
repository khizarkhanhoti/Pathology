package com.example.springjavafx.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/*
 * Class for collection of test ranging from one to many
 * results
 */
@Entity
@Setter
@Getter
public class Test {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	private String name;
	private String nrange;
	private String result;
	private int amount;
	
	public Test() {
	}

	@Override
	public String toString() {
		return name;
	}
}
