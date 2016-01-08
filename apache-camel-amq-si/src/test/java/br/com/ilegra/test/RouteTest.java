package br.com.ilegra.test;

import org.apache.camel.EndpointInject;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;
import org.sample.processor.FailureProcessor;
import org.sample.processor.MessageProcessor;

public class RouteTest extends CamelTestSupport {

	@EndpointInject(uri = "mock:result")
	protected MockEndpoint resultEndpoint;

	@EndpointInject(uri = "mock:error")
	protected MockEndpoint errorEndpoint;

	@Produce(uri = "direct:start")
	protected ProducerTemplate template;

	@Override
	public boolean isDumpRouteCoverage() {
		return true;
	}

	@EndpointInject(uri = "mock:jms:activemq:queue:loader.queue")
	protected MockEndpoint start;

	@Test
	public void testMessageProcessor() throws Exception {
		template.sendBody("direct:start", "Hello World");
		 resultEndpoint.assertIsSatisfied();
	}

	@Test
	public void testMessageFailureProcessor() throws Exception {
		template.sendBody("direct:start", null);
		resultEndpoint.assertIsSatisfied();
		errorEndpoint.assertIsSatisfied();
	}
	
	@Override
	protected RouteBuilder createRouteBuilder() {
		return new RouteBuilder() {
			public void configure() {
				errorHandler(deadLetterChannel("mock:error")
						.onRedelivery(new FailureProcessor())
						.useOriginalMessage()
						.maximumRedeliveries(1)
						.redeliveryDelay(0L)
						.retryAttemptedLogLevel(LoggingLevel.INFO));
				
				from("direct:start")
				.process(new MessageProcessor(null))
				.to("mock:result");
			}
		};
	}

}
