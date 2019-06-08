package com.remo.meter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import com.remo.meter.service.FormulaService;
import com.remo.meter.webservice.model.response.CustomFormulaRequest;

@Controller
public class RemoController {

	@Autowired
	private FormulaService formulaService;

//	@SendTo("/topic/greetings")
//	public EvalResult greeting() throws Exception {
//		return new EvalResult("Hello, " + HtmlUtils.htmlEscape("some string") + "!");
//	}

	@MessageMapping("/formula")
	public void setFormula(CustomFormulaRequest customFormula) {
		formulaService.setCustomFormula(customFormula.getFormula());
		System.out.println("Formula : " + customFormula.getFormula());

	}

}
