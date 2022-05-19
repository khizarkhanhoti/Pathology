package com.example.springjavafx.entities;

import com.example.springjavafx.tests.byRange.HB;
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
@AllArgsConstructor
public class Patient{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reg;

	@NotNull
    private String name;
	@NotNull
    private String gender;
	@NotNull
	private String specimen;
	@NotNull
    private String contact;
	@NotNull
    private String cnic;
	
	@ManyToOne
	@JoinColumn(name = "referred_by_id")
	@NotNull
    private Doctor referred_by;
	
	@OneToOne
	@JoinColumn(name = "hb_id")
	private HB hb;

    public Patient(String name, String gender, String specimen,
				   String contact, String cnic, Doctor referred_by) {
        this.name = name;
        this.gender = gender;
		this.specimen = specimen;
        this.contact = contact;
        this.cnic = cnic;
        this.referred_by = referred_by;
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Patient patient = (Patient) o;
		return reg != null && Objects.equals(reg, patient.reg);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
