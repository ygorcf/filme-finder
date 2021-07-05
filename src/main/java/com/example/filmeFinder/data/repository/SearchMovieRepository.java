package com.example.filmeFinder.data.repository;

import com.example.filmeFinder.domain.entity.MovieEntity;
import com.example.filmeFinder.domain.repository.BaseSearchMovieRepository;
import org.springframework.data.repository.support.Repositories;

public class SearchMovieRepository implements BaseSearchMovieRepository {
    @Override
    public MovieEntity saveMovie(MovieEntity movie) {
        return null;
    }
}
