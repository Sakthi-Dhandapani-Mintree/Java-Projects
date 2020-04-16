package io.httech.yorbitspringboot.service;

import java.util.Collection;

import io.httech.yorbitspringboot.model.Greeting;

public interface GreetingService {
	Collection<Greeting> findAll();

	Greeting findOne(Long id);
	Greeting create(Greeting greeting);
	Greeting update(Greeting greeting);

	void deleteGreeting(Long id);
}
