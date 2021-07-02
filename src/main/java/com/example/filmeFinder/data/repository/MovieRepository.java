package com.example.filmeFinder.data.repository;

import com.example.filmeFinder.data.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
