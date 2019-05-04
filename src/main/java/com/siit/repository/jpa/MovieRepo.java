package com.siit.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.siit.domain.Movie;

public interface MovieRepo extends CrudRepository<Movie, String> {

}
