package com.remo.meter.service;

import org.springframework.stereotype.Service;

@Service
public class FormulaService {

	private String customFormula = "raw";

	public String getCustomFormula() {
		return customFormula;
	}

	public void setCustomFormula(String customFormula) {
		this.customFormula = customFormula;
	}

}
