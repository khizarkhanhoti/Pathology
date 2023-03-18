package com.example.springjavafx.entities;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
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
	@NotNull
	@Column(name = "ispending")
	private Boolean isPending;
	@NotNull
	private int amount;
	
	@ManyToOne
	@JoinColumn(name = "referred_by_id")
	@NotNull
    private Doctor referred_by;
	
	//ToDo generating test results and database.
	@OneToOne
	@JoinColumn(name = "tests_id")
	private Test test;

    public Patient(String name, String gender, String specimen,
				   String contact, String cnic, Doctor referred_by, Test test, int amount) {
        this.name = name;
        this.gender = gender;
		this.specimen = specimen;
        this.contact = contact;
        this.cnic = cnic;
        this.referred_by = referred_by;
		this.test = test;
		this.isPending = true;
		this.amount = amount;
		if (amount == 0){
			setIsPending(false);
		}
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
	
	@Override
	public String toString() {
		return "Patient{" +
				"reg=" + reg +
				", name='" + name + '\'' +
				", gender='" + gender + '\'' +
				", specimen='" + specimen + '\'' +
				", contact='" + contact + '\'' +
				", cnic='" + cnic + '\'' +
				", referred_by=" + referred_by +
				", tests=" + test +
				'}';
	}
}
