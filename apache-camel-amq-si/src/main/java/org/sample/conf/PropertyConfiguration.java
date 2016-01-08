package org.sample.conf;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class PropertyConfiguration {

	public String getProperty(String key) throws ConfigurationException {
		return new PropertiesConfiguration("broker.properties").getProperty(key).toString();
	}
}
