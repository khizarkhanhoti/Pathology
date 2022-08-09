package com.example.springjavafx.entities;

import com.example.springjavafx.tests.collective.LFTs;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Tests {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	private int amount;
	
	@ManyToOne
	@JoinColumn(name = "lfts_id")
	private LFTs lfTs;
	
	public Tests(){
	
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return getTests();
	}
	
	public String getTests(){
		String tests = "";
		if (lfTs != null){
			tests += lfTs.getName();
		}
		
		return tests;
	}
	
}
