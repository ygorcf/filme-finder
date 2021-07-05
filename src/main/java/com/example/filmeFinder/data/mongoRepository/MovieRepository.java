package com.example.filmeFinder.data.mongoRepository;

import com.example.filmeFinder.data.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

}
