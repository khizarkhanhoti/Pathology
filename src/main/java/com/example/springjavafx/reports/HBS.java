package com.example.springjavafx.reports;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class HBS{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	private final String name = "HBS AG";
	private final String range = "UP TO 40 U/L";
	@NotNull
	private String result;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		HBS hbs = (HBS) o;
		return id != null && Objects.equals(id, hbs.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
