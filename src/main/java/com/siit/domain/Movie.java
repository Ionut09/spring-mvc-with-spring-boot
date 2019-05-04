package com.siit.domain;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static org.hibernate.annotations.NotFoundAction.IGNORE;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;

import lombok.Data;

@Entity
@Table(name = "movie_info")
@Data
public class Movie {

	@Id
	@Column(name = "movie_id")
	private String id;

	@Column(name = "movie_name")
	private String name;

	@Column(name = "year")
	private int year;

	@Column(name = "rating")
	private int rating;

	@ManyToMany(fetch = EAGER)
	@JoinTable(name="actor_movies",
				joinColumns = @JoinColumn(name = "movie_id", referencedColumnName="movie_id"),
				inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName="actor_id"))
	private List<Actor> actors = new ArrayList<>();

	@ManyToOne
	@NotFound(action = IGNORE)
	@JoinColumn(name="movie_id", insertable=false, updatable=false)
	private MovieGenre genre;

	@ManyToMany(fetch = LAZY)
	@JoinTable(name = "producer_movies", 
			   joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "movie_id"), 
			   inverseJoinColumns = @JoinColumn(name = "producer_id", referencedColumnName = "producer_id"))
	private List<Producer> producers = new ArrayList<>();
}
