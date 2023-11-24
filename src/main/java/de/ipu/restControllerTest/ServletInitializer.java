package de.ipu.restControllerTest;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		System.out.println("SpringApplicationBuilder here");
		logger.info("An INFO Message");
		return application.sources(RestControllerTestApplication.class);
	}

}
