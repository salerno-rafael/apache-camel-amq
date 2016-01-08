package org.sample.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;

public class FailureProcessor implements Processor {

	private static Logger logger = Logger.getLogger(FailureProcessor.class);

	public void process(Exchange exchange) throws Exception {
		Exception cause = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
		logger.error("Tratando erros");
		logger.error(cause.getMessage());
	}
}