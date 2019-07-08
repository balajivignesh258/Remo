package com.remo.meter.service;

import org.springframework.stereotype.Service;

@Service
public class FormulaService {

	private String customFormula = "raw";

	private String appendUnit = "";

	public String getCustomFormula() {
		return customFormula;
	}

	public void setCustomFormula(String customFormula) {
		this.customFormula = customFormula;
	}

	public String getAppendUnit() {
		return appendUnit;
	}

	public void setAppendUnit(String appendUnit) {
		this.appendUnit = appendUnit;
	}

}
