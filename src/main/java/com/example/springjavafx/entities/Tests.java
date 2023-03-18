package com.example.springjavafx.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Tests {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	private String name;
	private int amount;

	public Tests(){
	}

	public Tests(Long id, String name, int amount) {
		this.id = id;
		this.name = name;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Tests{" +
				"id=" + id +
				", name='" + name + '\'' +
				", amount=" + amount +
				'}';
	}
}
