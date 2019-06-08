package com.remo.meter.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

public class Util {
	/**
	 * Get the date string in the specified format.
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getFormatedDateTime(Date date, String format) {
		if (date == null)
			return "";

		DateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date);

	}

	public Util() {

	}

	public static MqttConnectOptions setUpConnectionOptions(String username, String password) {
		MqttConnectOptions connOpts = new MqttConnectOptions();
		connOpts.setCleanSession(true);
		connOpts.setUserName(username);
		connOpts.setPassword(password.toCharArray());
		return connOpts;
	}
}
