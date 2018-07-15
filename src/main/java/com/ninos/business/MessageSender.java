package com.ninos.business;

import com.ninos.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Profile("production")
@Service
public class MessageSender {

	private static final Logger LOG = LoggerFactory.getLogger(MessageSender.class);

	private final JmsTemplate jmsTemplate;
	private final String topic;

	@Autowired
	public MessageSender(
			JmsTemplate jmsTemplate,
			@Value("${jms.topic}") String topic
	) {
		this.jmsTemplate = jmsTemplate;
		this.topic = topic;
	}

	public void sendMessages() {
		IntStream.range(0, 10).forEach(i -> {
			Message message = new Message();
			message.setFrom("Spyros"+i);
			message.setTo("Recipient"+i);
			message.setBody("body"+i);

			LOG.info("Message sender: sending message nr {}: {}", i, message);
			jmsTemplate.convertAndSend(topic, message);
		});
	}
}
