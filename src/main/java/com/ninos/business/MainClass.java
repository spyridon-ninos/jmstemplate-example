package com.ninos.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Profile("production")
@Service
public final class MainClass implements ApplicationContextAware {

	private static final Logger LOG = LoggerFactory.getLogger(MainClass.class);
	private final MessageSender messageSender;

	private ApplicationContext applicationContext;

	@Autowired
	public MainClass(MessageSender messageSender) {
		this.messageSender = messageSender;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void runApp() {
		LOG.info("Starting to send messages...");
		messageSender.sendMessages();

		LOG.info("Done. Shutting down the app.");
		// we're done sending messages, time to shutdown the app context
		((ConfigurableApplicationContext) applicationContext).close();
	}
}
