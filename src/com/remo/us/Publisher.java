package com.remo.us;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

public class Publisher extends Util {

	MqttClient client = null;

	public Publisher() throws MqttException {
		System.out.println("== START PUBLISHER ==");
		client = new MqttClient(Constants.CONNECTION_URL, MqttClient.generateClientId());
		MqttConnectOptions connOpts = setUpConnectionOptions(Constants.USERNAME, Constants.PASSWORD);
		client.connect(connOpts);
	}

	public void publish(String message) throws MqttPersistenceException, MqttException {
		client.publish(Constants.TOPIC, new MqttMessage(message.getBytes()));
	}
}
