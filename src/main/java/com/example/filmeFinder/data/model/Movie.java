package com.example.filmeFinder.data.model;

import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {

	private @Id @GeneratedValue Long id;
	private String name;

	public Movie() {}

	public Movie(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Movie)){
			return false;
		}

		Movie o = (Movie) obj;

		return getId().equals(o.getId()) && getName().equals(o.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName());
	}

	@Override
	public String toString() {
		return getName();
	}

}
