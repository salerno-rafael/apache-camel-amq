package org.sample.route;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.commons.configuration.ConfigurationException;
import org.sample.conf.PropertyConfiguration;
import org.sample.processor.FailureProcessor;
import org.sample.processor.MessageProcessor;

public class CamelRoute {

	private MessageProcessor messageProcessor;

	private FailureProcessor failureProcessor;

	private PropertyConfiguration configuration;
	
	public CamelRoute(MessageProcessor messageProcessor, FailureProcessor failureProcessor,	PropertyConfiguration configuration) {
		this.messageProcessor = messageProcessor;
		this.failureProcessor = failureProcessor;
		this.configuration = configuration;
	}

	public void start() throws Exception {

		CamelContext context = new DefaultCamelContext();
		context.addComponent(configuration.getProperty("broker.componet.name"),JmsComponent.jmsComponent(connectionFactory()));

		context.addRoutes(new RouteBuilder() {
			public void configure() throws ConfigurationException {
				errorHandler(deadLetterChannel(configuration.getProperty("broker.dead.letter.queue"))
						.onRedelivery(failureProcessor)
						.useOriginalMessage()
						.maximumRedeliveries(5)
						.redeliveryDelay(5000)
						.retryAttemptedLogLevel(LoggingLevel.INFO));

				from(configuration.getProperty("broker.in.queue"))
					.process(messageProcessor)
					.to(configuration.getProperty("broker.out.queue"));
			}
		});
		context.start();
	}

	private ConnectionFactory connectionFactory() throws ConfigurationException {
		return new ActiveMQConnectionFactory(configuration.getProperty("broker.user"),
				configuration.getProperty("broker.password"), configuration.getProperty("broker.url"));
	}
}
