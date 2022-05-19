package com.example.springjavafx.tests.collective;

import com.example.springjavafx.tests.byRange.HDL;
import com.example.springjavafx.tests.byRange.LDL;
import com.example.springjavafx.tests.byState.TRIGLYCERIDE;

public class LIPID_PROFILE {
	private TRIGLYCERIDE triglyceride;
	private LDL ldl;
	private HDL hdl;

	public LIPID_PROFILE() {
	}

	public LIPID_PROFILE(TRIGLYCERIDE triglyceride, LDL ldl, HDL hdl) {
		this.triglyceride = triglyceride;
		this.ldl = ldl;
		this.hdl = hdl;
	}

	public TRIGLYCERIDE getTriglyceride() {
		return triglyceride;
	}

	public LDL getLdl() {
		return ldl;
	}

	public HDL getHdl() {
		return hdl;
	}
}
