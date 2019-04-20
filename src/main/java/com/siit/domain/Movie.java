package com.siit.domain;

import lombok.Data;

//@Entity
//@Table(name = "movie_info")
@Data
public class Movie {

//	@Column(name = "movie_id")
//	@Id
	private String id;

//	@Column(name = "movie_name")
	private String name;

//	@Column(name = "year")
	private int year;

//	@Column(name = "movie_id")
	private int rating;

	public Movie(String id, String name, int year, int rating) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.rating = rating;
	}

	public Movie() {

	}

//	@OneToMany // in mod normal era many-to-many
//	@JoinColumn(name = "actor_id", referencedColumnName = "id")
//	private List<Actor> actors;

}
