package io.httech.movieinfoservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.httech.movieinfoservice.model.Movie;

@RestController
@RequestMapping(value="/movies")
public class MovieResource {

	@RequestMapping(value="/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId")String movieId) {
		return new Movie("1","TITANIC");
	}
}
