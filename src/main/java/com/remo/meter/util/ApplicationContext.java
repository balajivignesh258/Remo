package com.remo.meter.util;

public class ApplicationContext extends java.util.HashMap<String, Object> {

	private static final long serialVersionUID = -5293612353021316332L;
	private static ApplicationContext applicationContext = null;

	private ApplicationContext() {
	}

	public static ApplicationContext getInstance() {
		if (applicationContext == null) {
			applicationContext = new ApplicationContext();
		}
		return applicationContext;
	}
}
