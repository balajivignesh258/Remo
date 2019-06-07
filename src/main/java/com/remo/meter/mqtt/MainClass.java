package com.remo.meter.mqtt;

import org.eclipse.paho.client.mqttv3.MqttException;

public class MainClass {

	public static void main(String[] args) throws MqttException {
		Publisher publisher = new Publisher();
		publisher.publish("1");

		Subscriber subscriber = new Subscriber();
	}

}