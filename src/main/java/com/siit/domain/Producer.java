package com.siit.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "producer_ids")
@Data
public class Producer {

	@Id
	@Column(name = "producer_id")
	private String id;

	@Column(name = "producer_name")
	private String name;

	@ManyToMany(mappedBy = "producers")
	@JsonIgnore
	private List<Movie> movies = new ArrayList<>();
}
