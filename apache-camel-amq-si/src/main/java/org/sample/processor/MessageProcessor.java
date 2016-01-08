package org.sample.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;
import org.sample.entrypoint.RemessaEntryPoint;

import br.com.ilegra.contract.LoaderInputMessage;
import br.com.ilegra.contract.LoaderOutupMessage;

public class MessageProcessor implements Processor {

	public MessageProcessor(RemessaEntryPoint remessaEntryPoint) {
		this.remessaEntryPoint = remessaEntryPoint;
	}

	private static Logger logger = Logger.getLogger(MessageProcessor.class);

	private RemessaEntryPoint remessaEntryPoint;

	public void process(Exchange exchange) throws Exception {
		try {
			logger.info("Processando menssagem");
			LoaderOutupMessage output = list(exchange.getIn().getBody(String.class));
			exchange.getOut().setBody("Message Out " + output.toString());
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	private LoaderOutupMessage list(String message) {
		return remessaEntryPoint.list(new LoaderInputMessage(message));
	}
}
