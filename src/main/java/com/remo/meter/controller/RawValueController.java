package com.remo.meter.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.remo.meter.webservice.model.request.Greeting;
import com.remo.meter.webservice.model.response.RawValue;

@Controller
public class RawValueController {

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(RawValue message) throws Exception {

		Thread.sleep(1000); // simulated delay
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getValue()) + "!");

	}

}
