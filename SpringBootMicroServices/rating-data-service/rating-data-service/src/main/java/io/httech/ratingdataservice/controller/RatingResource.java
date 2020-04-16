package io.httech.ratingdataservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.httech.ratingdataservice.model.Rating;
import io.httech.ratingdataservice.model.UserRating;

@RestController
@RequestMapping(value="/ratingsdata")

public class RatingResource {

	@GetMapping(value="/{moviId}")
	public Rating getRatingInfo(@PathVariable("moviId")String moviId) {
		return new Rating("1",5);
	}
	@GetMapping(value="/user/{userId}")
	public UserRating getuserRatingInfo(@PathVariable("userId")String userId) {
		List<Rating> listOfRating = Arrays.asList(new Rating("1",3),new Rating("2",5),new Rating("3",2));
		UserRating userRating = new UserRating();
		userRating.setUserRating(listOfRating);
		return userRating;
	}
}
