package com.example.springjavafx.tests.collective;

import com.example.springjavafx.tests.byRange.T3;
import com.example.springjavafx.tests.byRange.T4;
import com.example.springjavafx.tests.byRange.TSH;

public class TFT {
	private TSH tsh;
	private T3 t3;
	private T4 t4;

	public TFT() {
	}

	public TFT(TSH tsh, T3 t3, T4 t4) {
		this.tsh = tsh;
		this.t3 = t3;
		this.t4 = t4;
	}

	public TSH getTsh() {
		return tsh;
	}

	public T3 getT3() {
		return t3;
	}

	public T4 getT4() {
		return t4;
	}
}
