package org.sample;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ServiceLoaderModule.class })
public class AppConfig {

}
