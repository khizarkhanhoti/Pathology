package com.example.springjavafx.tests.collective;

import com.example.springjavafx.tests.byRange.S_CHLORIDE;
import com.example.springjavafx.tests.byRange.S_SODIUM;

public class S_ELECTROLYTES {
	private S_SODIUM sodium;
	private S_POTASSIUM potassium;
	private S_CHLORIDE chloride;

	public S_ELECTROLYTES(S_SODIUM sodium, S_POTASSIUM potassium, S_CHLORIDE chloride) {
		this.sodium = sodium;
		this.potassium = potassium;
		this.chloride = chloride;
	}

	public S_SODIUM getSodium() {
		return sodium;
	}

	public S_POTASSIUM getPotassium() {
		return potassium;
	}

	public S_CHLORIDE getChloride() {
		return chloride;
	}

	public S_ELECTROLYTES() {
	}
}
