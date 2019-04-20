package com.siit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siit.domain.Movie;
import com.siit.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	// @Qualifier("movieBuzz")
	private MovieRepository movieRepository;

	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.getAllMovies();
	}

	@Override
	public Movie getMovieById(String movieId) {
		return movieRepository.getMovieById(movieId);
	}

	@Override
	public Movie updateMovie(Movie movie) {
		return movieRepository.updateMovie(movie);
	}

	@Override
	public void deleteMovie(String movieId) {
		movieRepository.deleteMovie(movieId);
	}

	@Override
	public Movie createMovie(Movie movie) {
		return movieRepository.createMovie(movie);
	}

}
