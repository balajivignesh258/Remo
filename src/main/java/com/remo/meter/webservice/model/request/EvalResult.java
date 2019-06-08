package com.remo.meter.webservice.model.request;

public class EvalResult {

	private String evalResultValue;

	public EvalResult(String string) {
		this.setEvalResultValue(string);
	}

	public String getEvalResultValue() {
		return evalResultValue;
	}

	public void setEvalResultValue(String evalResultValue) {
		this.evalResultValue = evalResultValue;
	}

}
