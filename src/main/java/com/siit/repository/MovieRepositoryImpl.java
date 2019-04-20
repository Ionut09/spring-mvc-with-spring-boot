package com.siit.repository;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.siit.domain.Movie;

@Repository // ("movieBuzz")
public class MovieRepositoryImpl implements MovieRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String getAllMoviesSql = "SELECT * FROM movie_info";
	private String getMovieByIdSql = "SELECT * FROM movie_info WHERE movie_id = ?";
	private String updateMovieSql = "UPDATE movie_info SET rating = ?, movie_name = ?, year=? where movie_id = ?";
	private String deleteMovieSql = "DELETE FROM movie_info WHERE movie_id = ?";
	private String createMovieSql = "INSERT INTO movie_info (rating, movie_name, year, movie_id) VALUES (?,?,?,?)";

	@Override
	public List<Movie> getAllMovies() {
		return jdbcTemplate.query(getAllMoviesSql, getMovieMapper());
	}

	@Override
	public Movie getMovieById(String movieId) {
		return jdbcTemplate.queryForObject(getMovieByIdSql, new Object[] { movieId }, getMovieMapper());
	}

	@Override
	// @Transactional(value=REQUIRED)
	public Movie updateMovie(Movie movie) {
		int updatedRows = jdbcTemplate.update(updateMovieSql, movie.getRating(), movie.getName(), movie.getYear(),
				movie.getId());
		if (updatedRows > 0) {
			return getMovieById(movie.getId());
		}
		throw new IllegalStateException("The movie hasn'y been updated");
	}

	@Override
	public void deleteMovie(String movieId) {
		int deletedRows = jdbcTemplate.update(deleteMovieSql, movieId);
		if (deletedRows == 0) {
			throw new IllegalStateException("The movie hasn't been deleted");
		}
	}

	@Override
	public Movie createMovie(Movie movie) {
		int createdRows = jdbcTemplate.update(createMovieSql, movie.getRating(), movie.getName(), movie.getYear(),
				movie.getId());
		if (createdRows > 0) {
			return getMovieById(movie.getId());
		}
		throw new IllegalStateException("The movie hasn'y been created");
	}
	private RowMapper<Movie> getMovieMapper() {
		return (ResultSet rs, int rowNum) -> {
			Movie movie = new Movie();
			movie.setId(rs.getString("movie_id"));
			movie.setName(rs.getString("movie_name"));
			movie.setYear(rs.getInt("year"));
			movie.setRating(rs.getInt("rating"));
			return movie;
		};
	}

}