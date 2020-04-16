package com.resoursetechmappings.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.resoursetechmappings.entity.ResourceBean;
import com.resoursetechmappings.service.ResourceBeanService;

@RestController
@RequestMapping(value="/rtm")
public class ResourseMappingController {

	private final Logger logger = LoggerFactory.getLogger(ResourseMappingController.class);
	@Autowired
	private ResourceBeanService resourceService;
	
	
	@GetMapping(value="/hello")
	public String sayHello() {
		return "Hello Satkhi";
	}

	/**
	 * This method used insert the resource into Database
	 */

	@PostMapping(value = "/addresource", produces = { "application/JSON" })
	public String addResource(@RequestBody String resource) {
		logger.info("addResource method reached and resource info :->" + resource);
		try {
			ResourceBean resourceBean = new ObjectMapper().readValue(resource, ResourceBean.class);
			boolean value = resourceService.addResourece(resourceBean);
			if (value) {
				return new ObjectMapper().writeValueAsString("Success");
			} else {
				return new ObjectMapper().writeValueAsString("Failed");
			}

		} catch (JsonParseException e) {
			logger.info("JsonParseException" + e);

		} catch (JsonMappingException e) {
			logger.info("JsonMappingException" + e);
		} catch (IOException e) {
			logger.info("IOException :" + e);
		}
		logger.info("addResource method completed");
		return "";

	}

	/**
	 * This method used insert the resource into Database
	 */

	@GetMapping(value = "/getResource/{id}")
	public String getResource(@PathVariable("id") int id) {
		logger.info("getResource method requested with id" + id);
		String result = null;
		try {
			result = new ObjectMapper().writeValueAsString(resourceService.getResource(id));
		} catch (JsonGenerationException e) {
			logger.info("JsonParseException" + e);
		} catch (JsonMappingException e) {
			logger.info("JsonMappingException" + e);
		} catch (IOException e) {
			logger.info("IOException :" + e);
		}
		logger.info("Get Resource method completed !!!");
		return result;
	}

	/**
	 * This method used to remove the resource from the database based on the given
	 * id
	 */
	@DeleteMapping(value = "/removeResource/{id}")
	public void removeResource(@PathVariable("id") int id) {
		logger.info("removeResource method requested with id" + id);
		int value = resourceService.removeResource(id);
		if (value > 0) {
			logger.info(value + "I has been removed from Data Base successfully");
		} else {
			logger.info(value + "Not removed from Data Base");
		}
	}
}
