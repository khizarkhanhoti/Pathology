package com.example.springjavafx.tests.collective;

import com.example.springjavafx.tests.byRange.Alkaline_Phosphatase;
import com.example.springjavafx.tests.byRange.SGPT;
import com.example.springjavafx.tests.byRange.S_BILIRUBIN;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class LFTs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	public final String name = "LFTs";
	
	@ManyToOne
	@JoinColumn(name = "s_bilirubin_id")
	public S_BILIRUBIN sbr;
	
	@ManyToOne
	@JoinColumn(name = "sgpt_id")
	public SGPT sgpt;
	
	@ManyToOne
	@JoinColumn(name = "alkaline_phosphatase_id")
	public Alkaline_Phosphatase alkaline_phosphatase;
	
	private final int amount = 300;
	
	public LFTs(){
	
	}
	
	public LFTs(S_BILIRUBIN sbr, SGPT sgpt, Alkaline_Phosphatase alkaline_phosphatase){
		this.sbr = sbr;
		this.sgpt = sgpt;
		this.alkaline_phosphatase = alkaline_phosphatase;
		System.out.println("lfts created.");
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return "LFTs{" +
				"id=" + id +
				", name='" + name + '\'' +
				", sbr=" + sbr +
				", sgpt=" + sgpt +
				", alkaline_phosphatase=" + alkaline_phosphatase +
				", amount=" + amount +
				'}';
	}
}
