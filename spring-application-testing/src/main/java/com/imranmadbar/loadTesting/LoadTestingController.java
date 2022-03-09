package com.imranmadbar.loadTesting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadTestingController {

	Logger logger = LoggerFactory.getLogger(LoadTestingController.class);

	@GetMapping("/lts2")
	public String lts2() {
		logger.info("Spring Boot  Load testing 2");
		return "Spring Boot  Load testing 2";
	}

	@GetMapping("/lts1")
	public String lts1() {
		logger.info("Spring Boot  Load testing 1");
		return "Spring Boot  Load testing 1";
	}

}
