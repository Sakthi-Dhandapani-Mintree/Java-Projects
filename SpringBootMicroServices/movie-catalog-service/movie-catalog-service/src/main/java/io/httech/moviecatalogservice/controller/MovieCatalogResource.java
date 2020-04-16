package io.httech.moviecatalogservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.httech.moviecatalogservice.model.CatalogItem;
import io.httech.moviecatalogservice.model.Movie;
import io.httech.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping(value = "/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;

//	@Autowired
//	private WebClient.Builder webClientBuilder;

	@GetMapping(value = "/{userId}")
	public List<CatalogItem> getCatalogFor(@PathVariable("userId") String userId) {
		UserRating ratings = restTemplate.getForObject("http://RATING-INFO-SERVICE/ratingsdata/user/" + userId,
				UserRating.class);
		return ratings.getUserRating().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/" + rating.getMovieId(), Movie.class);
			// Another way calling to other services
//			Movie movie = webClientBuilder.build().get().uri("http://localhost:8102/movies/" + rating.getMovieId())
//					.retrieve().bodyToMono(Movie.class).block();

			return new CatalogItem(movie.getMovideName(), "Very Good Movie", rating.getRating());
		}).collect(Collectors.toList());

	}

}
