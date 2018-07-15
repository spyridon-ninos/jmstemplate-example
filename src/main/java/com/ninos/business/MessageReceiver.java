package com.ninos.business;

import com.ninos.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Profile("production")
@Service
public class MessageReceiver {

	private static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);

	@JmsListener(destination = "${jms.topic}", containerFactory = "messageFactory")
	public void onMessageReceive(Message message) {
		LOG.info("Received message: {}", message);
	}
}
