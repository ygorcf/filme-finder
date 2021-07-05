package com.example.filmeFinder.domain.repository;

import com.example.filmeFinder.domain.entity.MovieEntity;

public interface BaseSearchMovieRepository {
    MovieEntity saveMovie(MovieEntity movie);
}
