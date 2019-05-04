package com.siit.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "genre")
@Data
public class MovieGenre {

	@Id
	@Column(name = "movie_id")
	private String id;
	
	@OneToMany
	@JoinColumn(name = "movie_id", referencedColumnName="movie_id")
	@MapsId
	@JsonIgnore
	private List<Movie> movies = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	@Column(name = "genre")
	private Genre movieType;
}
