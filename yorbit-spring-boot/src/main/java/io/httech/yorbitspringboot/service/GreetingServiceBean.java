package io.httech.yorbitspringboot.service;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.httech.yorbitspringboot.model.Greeting;
import io.httech.yorbitspringboot.repository.GreetingRepository;

@Service
public class GreetingServiceBean implements GreetingService {

	@Autowired
	private GreetingRepository greetingRepository;

	@Override
	public Collection<Greeting> findAll() {
		Collection<Greeting> greetings = greetingRepository.findAll();
		return greetings;
	}

	@Override
	public Greeting findOne(Long id) {
		Greeting greeting = greetingRepository.getOne(id);
		return greeting;
	}

	@Override
	public Greeting create(Greeting greeting) {
		if (greeting.getId() == null) {
			return null;
		}
		Greeting savedGeeting = greetingRepository.save(greeting);
		return savedGeeting;
	}

	@Override
	public Greeting update(Greeting greeting) {
		Greeting greetingPestisted = findOne(greeting.getId());
		if (greetingPestisted == null) {
			// cann't update Greeting
			return null;
		}
		Greeting updateGreeting = greetingRepository.save(greeting);
		return updateGreeting;
	}

	@Override
	public void deleteGreeting(Long id) {
		greetingRepository.deleteById(id);

	}

}
