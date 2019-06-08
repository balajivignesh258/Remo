package com.remo.meter;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.remo.meter.mqtt.Publisher;
import com.remo.meter.mqtt.Subscriber;
import com.remo.meter.webservice.util.FileStorageProperties;

@ComponentScan(basePackages = "com.remo.meter")
@EnableConfigurationProperties({ FileStorageProperties.class })
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	static final Logger logger = LogManager.getLogger(Application.class);


	public static void main(String[] args) {
		BasicConfigurator.configure();
		logger.info("Initializing application Remo");
		SpringApplication.run(Application.class, args);
		try {
			//Subscriber subscriber = new Subscriber();
			//Publisher publisher = new Publisher();
			//publisher.publish("1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
