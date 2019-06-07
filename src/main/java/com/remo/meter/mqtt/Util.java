package com.remo.meter.mqtt;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

public class Util {
	public static MqttConnectOptions setUpConnectionOptions(String username, String password) {
		MqttConnectOptions connOpts = new MqttConnectOptions();
		connOpts.setCleanSession(true);
		connOpts.setUserName(username);
		connOpts.setPassword(password.toCharArray());
		return connOpts;
	}
}
