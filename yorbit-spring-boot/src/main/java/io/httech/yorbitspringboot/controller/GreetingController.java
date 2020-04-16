package io.httech.yorbitspringboot.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.httech.yorbitspringboot.model.Greeting;
import io.httech.yorbitspringboot.service.GreetingService;

@RestController

public class GreetingController extends BaseController{

	@Autowired
	private GreetingService greetingService;

	@GetMapping(value = "/api/greetings/")

	public ResponseEntity<Collection<Greeting>> getGreetings() {
		Collection<Greeting> greetings = greetingService.findAll();
		return new ResponseEntity<Collection<Greeting>>(greetings, HttpStatus.OK);
	}

	@GetMapping(value = "/api/greetings/{id}")

	public ResponseEntity<Greeting> getGreeting(@PathVariable("id") long id) {
		Greeting greeting = greetingService.findOne(id);
		if (greeting == null) {
			return new ResponseEntity<Greeting>(greeting, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);

	}

	@PostMapping(value = "/api/greetings/")

	public ResponseEntity<Greeting> saveGreeting(@RequestBody Greeting greeting) {

		Greeting greetings = greetingService.create(greeting);
		return new ResponseEntity<Greeting>(greetings, HttpStatus.CREATED);
	}

	@PutMapping(value = "/api/greetings/")

	public ResponseEntity<Greeting> updateGreeting(@RequestBody Greeting greeting) {
		Greeting updateGreet = greetingService.create(greeting);
		if (updateGreet == null) {
			return new ResponseEntity<Greeting>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Greeting>(updateGreet, HttpStatus.OK);
	}

	@DeleteMapping(value = "/api/greetings/{id}")

	public ResponseEntity<Greeting> deleteGreeting(@PathVariable("id") long id, @RequestBody Greeting greeting) {
		greetingService.deleteGreeting(id);
		return new ResponseEntity<Greeting>(HttpStatus.NO_CONTENT);
	}
}
