package com.example.springjavafx.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.sql.Blob;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Report {
	@Id
	@Column(name = "report_name", nullable = false)
	private String name;

	@Lob
	private Blob jasper_report;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Report report = (Report) o;
		return name != null && Objects.equals(name, report.name);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
