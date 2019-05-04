package com.siit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.siit.domain.Movie;
import com.siit.service.MovieService;

@RestController
@RequestMapping("/app") // requesturi de forma http://localhost:9999/app/movies
public class MovieController {

	@Autowired
	private MovieService movieService;

	@RequestMapping(value = "/urlTest")
	public String testSpringBootApp() {
		return "My app is running properly!";
	}

	// @RequestMapping(value = "/movies", method = RequestMethod.GET)
	@GetMapping("/all-movies")
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}

	@GetMapping("/movies/{id}")
	public Movie getMovieByIdWithPathVariable(@PathVariable("id") String movieId) {
		System.out.println("From getMovieByIdWithPathVariable method!!!!!!!!!!!!!!!!!!");
		return movieService.getMovieById(movieId);
	}

	@GetMapping("/movies")
	public Movie getMovieByIdWithQueryParam(@RequestParam("movie_id") String movieId) {
		System.out.println("From getMovieByIdWithQueryParam method!!!!!!!!!!!!!!!!!!");
		return movieService.getMovieById(movieId);
	}

	@PutMapping("/movie")
	public Movie updateMovie(@RequestBody Movie movie) {
		return movieService.updateMovie(movie);
	}

	@DeleteMapping("/movie")
	public void deleteMovie(@RequestParam("movie_id") String movieId) {
		movieService.deleteMovie(movieId);
	}

	@PostMapping("/movie")
	public Movie createMovie(@RequestBody Movie movie) {
		return movieService.createMovie(movie);
	}

}
