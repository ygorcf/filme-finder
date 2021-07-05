package com.example.filmeFinder.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "movie")
public class Movie {

	private @Id String id;

	private String search;
	private String title;
	private String originalTitle;
	private String gender;
	private String releaseDate;
	private boolean adult;
	private double popularity;
	private int voteCount;

	public Movie(String id, String search, String title, String originalTitle, String gender, String releaseDate, boolean adult, double popularity, int voteCount) {
		this.id = id;
		this.search = search;
		this.title = title;
		this.originalTitle = originalTitle;
		this.gender = gender;
		this.releaseDate = releaseDate;
		this.adult = adult;
		this.popularity = popularity;
		this.voteCount = voteCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public boolean isAdult() {
		return adult;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}

	public double getPopularity() {
		return popularity;
	}

	public void setPopularity(double popularity) {
		this.popularity = popularity;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Movie movie = (Movie) o;
		return adult == movie.adult && Double.compare(movie.popularity, popularity) == 0 && voteCount == movie.voteCount && Objects.equals(id, movie.id) && Objects.equals(search, movie.search) && Objects.equals(title, movie.title) && Objects.equals(originalTitle, movie.originalTitle) && Objects.equals(gender, movie.gender) && Objects.equals(releaseDate, movie.releaseDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, search, title, originalTitle, gender, releaseDate, adult, popularity, voteCount);
	}
}
