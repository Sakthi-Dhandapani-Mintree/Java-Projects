package io.httech.moviecatalogservice.model;

public class Movie {
	private String movieId;
	private String movideName;
	public Movie() {
		
	}
	
	public Movie(String movieId, String movideName) {
		this.movieId = movieId;
		this.movideName = movideName;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovideName() {
		return movideName;
	}

	public void setMovideName(String movideName) {
		this.movideName = movideName;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movideName=" + movideName + "]";
	}

}
