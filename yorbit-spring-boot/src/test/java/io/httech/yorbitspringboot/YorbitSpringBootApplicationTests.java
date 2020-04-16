package io.httech.yorbitspringboot;

import java.io.IOException;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.httech.yorbitspringboot.model.Greeting;
import io.httech.yorbitspringboot.service.GreetingService;

@SpringBootTest
class YorbitSpringBootApplicationTests {

	@Autowired
	private GreetingService service;
	
	@Mock
	protected MockMvc mvc;
	
	
	
	 
	
	protected String mapToJson(Object object) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(object);
	}
	protected <T> T mapFromJson(String json, Class<T> clazz) throws JsonParseException,JsonMappingException,IOException{
		ObjectMapper objMapper = new ObjectMapper();
		return objMapper.readValue(json, clazz);
	}
	//@Test
	public void findAll() {
		Collection<Greeting> greet = service.findAll();
		Assert.assertNotNull("Filure expected to not null", greet);
		Assert.assertEquals("Filure expected to not null", 2, greet.size());

	}
	//@Test
	public void controllerTest() throws Exception{
		String url = "/api/greetings/";
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON)).andReturn();
		String context = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();
		Assert.assertEquals("Expected values is ", 200, status);
		Assert.assertTrue("Failure ", context.trim().length() > 0);
	}

}
