package org.sample;

import org.sample.adapter.RemessaEntityAdapter;
import org.sample.adapter.RemessaToOutputAdapter;
import org.sample.business.RemessaBusiness;
import org.sample.conf.PropertyConfiguration;
import org.sample.dao.RemessaDao;
import org.sample.entrypoint.RemessaEntryPoint;
import org.sample.processor.FailureProcessor;
import org.sample.processor.MessageProcessor;
import org.sample.route.CamelRoute;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceLoaderModule {

	@Bean
	public CamelRoute route() {
		return new CamelRoute(
				new MessageProcessor(remessaEntryPoint()),
				new FailureProcessor(),
				new PropertyConfiguration());
	}

	private RemessaBusiness remessaBusiness() {
		return new RemessaBusiness(
				new RemessaDao(), 
				new RemessaEntityAdapter());
	}

	private RemessaEntryPoint remessaEntryPoint() {
		return new RemessaEntryPoint(
				remessaBusiness(), 
				new RemessaToOutputAdapter());
	}
}
