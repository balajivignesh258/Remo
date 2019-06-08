package com.remo.meter.util;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Constants {
	static final Logger logger = LogManager.getLogger(Constants.class);

	public static final String TOPIC = "balajivignesh258/feeds/readingfeed";
	public static final String CONNECTION_URL = "tcp://io.adafruit.com:1883";
	public static final String USERNAME = "balajivignesh258";
	public static final String PASSWORD = "493330ed2a854204a2e69406076c7cf1";

	@Context
	static ServletContext context;
	private static final int TOKEN_EXPIRE_TIME = 30; // In minutes

	public static int getTokenExpireTime() {
		return TOKEN_EXPIRE_TIME;
	}

	private Constants() {
	}

}
