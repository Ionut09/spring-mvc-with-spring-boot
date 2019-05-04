package com.siit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siit.domain.Movie;
import com.siit.repository.jdbc.MovieRepository;
import com.siit.repository.jpa.MovieRepo;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	// @Qualifier("movieBuzz")
	private MovieRepository movieRepository;
	@Autowired
	// @Qualifier("movieBuzz")
	private MovieRepo movieRepo;
	
	

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movies = new ArrayList<>();
		movieRepo.findAll()
				 .forEach(movies::add);
		return movies;
	}

	@Override
	public Movie getMovieById(String movieId) {
		return movieRepo.findById(movieId).get();
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
