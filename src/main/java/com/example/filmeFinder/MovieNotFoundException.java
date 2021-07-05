package com.example.filmeFinder;

public class MovieNotFoundException extends RuntimeException {

  MovieNotFoundException(String id) {
    super("Could not find movie " + id);
  }
}
