package com.example.springjavafx.tests.byRange;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class HB {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "name")
	public String NAME = "HEMOGLOBIN";
	@Column(name = "normal_range")
	public  String NORMAL_RANGE = "M.13-----15 g/dl\nF.12-----14 g/dl";
	private String result;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result + " g/dl";
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		HB hb = (HB) o;
		return id != null && Objects.equals(id, hb.id);
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
