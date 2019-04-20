package com.siit.service;

import java.util.List;

import com.siit.domain.Movie;

public interface MovieService {

	List<Movie> getAllMovies();

	Movie getMovieById(String movieId);

	Movie updateMovie(Movie id);

	void deleteMovie(String movieId);

	Movie createMovie(Movie movie);

}