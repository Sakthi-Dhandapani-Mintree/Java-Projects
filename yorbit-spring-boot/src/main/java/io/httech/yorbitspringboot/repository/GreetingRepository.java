package io.httech.yorbitspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.httech.yorbitspringboot.model.Greeting;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long> {

}
