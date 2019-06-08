package com.remo.meter.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.remo.meter.webservice.model.request.EvalResult;
import com.remo.meter.webservice.model.response.CustomFormula;

@Controller
public class RemoController {

	@SendTo("/topic/greetings")
	public EvalResult greeting() throws Exception {
		return new EvalResult("Hello, " + HtmlUtils.htmlEscape("some string") + "!");
	}

	@MessageMapping("/formula")
	public void setFormula(CustomFormula customFormula) {
		System.out.println("Formula : " + customFormula.getFormula());
	}

}
