package com.sakthi.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.sakthi.entity.DockerServices;
import com.sakthi.service.ReadLogsServcie;

@RestController
@RequestMapping(value = "/readlogs")
public class ReadFileController {
	private static final Logger logger = LogManager.getLogger(ReadFileController.class);

	@Autowired
	ReadLogsServcie readLogsServcie;
	private static Session session = null;

	public void geLogsFromEc2Machine() {
		System.out.println("Method Called");
		
		session = readLogsServcie.getSSHConnection();
		
	}
	
	@GetMapping(value = "/list")
	public List<DockerServices> getListOfServices() {
		logger.debug("Try to collect list of services from Instance"); 
		List<DockerServices> listOfDockerService = readLogsServcie.getListDockerServices();
		for (DockerServices d : listOfDockerService) {
			System.out.println(d.toString());
		}
		logger.debug("List of services collected from Instance");
		return listOfDockerService;
	}

	/**
	 * Download API has been temporarlly not fully implemented
	 * 
	 * @param serviceName
	 */
	@GetMapping(value = "/{serviceName}/download")
	public void downloadLogFiles(@PathVariable("serviceName") String serviceName) {
		logger.info(serviceName);
		System.out.println("Download File method called");
		if (session == null) {
			geLogsFromEc2Machine();
		}
		readLogsServcie.downloadFileFromInstance(session, serviceName);
	}

	@GetMapping(value = "/{serviceName}/view")
	public String viewLogFiles(@PathVariable("serviceName") String serviceName) {
		logger.info(serviceName);
		System.out.println("View Logse method called");
		if (session == null) {
			geLogsFromEc2Machine();
		}
		return readLogsServcie.viewServiceLogs(session, serviceName);

	}
}