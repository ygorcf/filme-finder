package com.example.filmeFinder;

public class MovieNotFoundException extends RuntimeException {

  MovieNotFoundException(Long id) {
    super("Could not find movie " + id);
  }
}
