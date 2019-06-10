package com.remo.meter.service;

import java.math.BigDecimal;
import java.util.Date;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.remo.meter.util.Constants;
import com.remo.meter.util.Util;
import com.remo.meter.webservice.model.request.EvalResult;
import com.udojava.evalex.Expression;

@Service
public class SubscriberService extends Util implements MqttCallback {

	@Autowired
	private SimpMessagingTemplate template;

	@Autowired
	private FormulaService formulaService;

	MqttClient client = null;

	public SubscriberService() throws MqttException {
		System.out.println("== START SUBSCRIBER ==");
		client = new MqttClient(Constants.CONNECTION_URL, MqttClient.generateClientId());
		MqttConnectOptions connOpts = Util.setUpConnectionOptions(Constants.USERNAME, Constants.PASSWORD);
		client.setCallback(this);
		client.connect(connOpts);
		client.subscribe(Constants.TOPIC);
	}

	@Override
	public void connectionLost(Throwable cause) {
		System.out.println("Connection lost because: " + cause);
		System.exit(1);

	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		System.out.println(String.format("[%s] %s", topic, new String(message.getPayload())));

		String responseMessage = "Exception";

		try {
			BigDecimal result = null;
			result = new Expression(formulaService.getCustomFormula())
					.with("raw", new BigDecimal(new String(message.getPayload()))).eval();
			responseMessage = result+"";
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.template.convertAndSend("/topic/evalresult", new EvalResult(responseMessage));
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {

	}

}
