package com.remo.meter.webservice;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@CrossOrigin()
@Api(value = "Authorization")
@RestController
public class Util extends WebUtil {
	static final Logger logger = LogManager.getLogger(Util.class);

	/**
	 * Returns the version in a plain string
	 * 
	 * @param httprequest
	 * @param httpresponse
	 * @return
	 */
	@GetMapping(value = "/api/version")
	public void getVersion(@Context final HttpServletRequest httprequest,
			@Context final HttpServletResponse httpresponse) {
		try {
			logger.info("Serving web service /api/version");
			String fileName = "version.properties";
			File file = ResourceUtils.getFile("classpath:" + fileName);
			Properties prop = new Properties();
			prop.load(new FileInputStream(file));
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("version", prop.getProperty("version"));
			processReturn(httpresponse, 0, "application/json", jsonObject.toString());
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			processReturn(httpresponse, 0, "application/json", "1.0");
		}
	}

	/**
	 * Test ping
	 */
	@GetMapping(value = "/api/ping")
	public void getPing() {
		// Simple ping request. No implementation necessary.
	}
}
