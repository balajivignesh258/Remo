package com.remo.meter.util;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Constants {
	static final Logger logger = LogManager.getLogger(Constants.class);

	@Context
	static ServletContext context;
	private static final int TOKEN_EXPIRE_TIME = 30; // In minutes

	public static int getTokenExpireTime() {
		return TOKEN_EXPIRE_TIME;
	}

	private Constants() {
	}

}
