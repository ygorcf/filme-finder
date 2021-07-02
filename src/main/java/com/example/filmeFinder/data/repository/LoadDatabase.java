package com.example.filmeFinder.data.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.filmeFinder.data.model.Movie;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(MovieRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Movie("Batman")));
      log.info("Preloading " + repository.save(new Movie("Oi")));
    };
  }
}
