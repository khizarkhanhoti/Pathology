package com.example.springjavafx.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String password;
	private String authorization;
	private Boolean active;
	
	public User(){
	
	}
	
	public User(String name, String password, String authorization){
		this.name = name;
		this.password = password;
		this.authorization = authorization;
		this.active = false;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
