package com.example.springjavafx.tests.collective;

import com.example.springjavafx.tests.byRange.BleedingTime;
import com.example.springjavafx.tests.byRange.ClottingTime;

public class CT_BT {
	private BleedingTime bleedingTime;
	private ClottingTime clottingTime;

	public CT_BT() {
	}

	public CT_BT(BleedingTime bleedingTime, ClottingTime clottingTime) {
		this.bleedingTime = bleedingTime;
		this.clottingTime = clottingTime;
	}

	public BleedingTime getBleedingTime() {
		return bleedingTime;
	}

	public ClottingTime getClottingTime() {
		return clottingTime;
	}
}
