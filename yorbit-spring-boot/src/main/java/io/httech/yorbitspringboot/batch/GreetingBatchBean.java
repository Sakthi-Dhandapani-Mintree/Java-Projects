package io.httech.yorbitspringboot.batch;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import io.httech.yorbitspringboot.model.Greeting;
import io.httech.yorbitspringboot.service.GreetingService;

@Profile("batch")
@Component
public class GreetingBatchBean {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private GreetingService greetingService;
	 
	//@Scheduled(cron = "${batch.greeting.cron}")
	public void cronJob() {
		
		logger.info("-->Cron Job started");
		Collection<Greeting> greeting = greetingService.findAll();
		logger.info("There are  {} greetings in the data store ", greeting.size());
		logger.info("-->Cron job done");
	}

	//@Scheduled(fixedDelayString = "15000")
	public void fixedRateJobWithInitalDelay() {
		logger.info("-->fixedRateJobWithInitalDelay");
		long pause = 5000;
		long start = System.currentTimeMillis();
		do {
			if (start + pause < System.currentTimeMillis()) {
				break;
			}
		} while (true);
		logger.info("Processing time was {} seconds" + pause / 1000);
		logger.info("----Done ----");
	}

//	@Scheduled(initialDelayString = "${batch.greeting.initialDelay}", fixedDelayString = "${batch.greeting.fixedDelay}")
	public void fixedDelayJobWithInitalDelay() {
		logger.info("-->fixedDelayJobWithInitalDelay");
		long pause = 5000;
		long start = System.currentTimeMillis();
		do {
			if (start + pause < System.currentTimeMillis()) {
				break;
			}
		} while (true);
		logger.info("Processing time was {} seconds" + pause / 1000);
		logger.info("----Done ----");
		logger.info("--fixedDelayJobWithInitalDelay --Done");
	}
}
