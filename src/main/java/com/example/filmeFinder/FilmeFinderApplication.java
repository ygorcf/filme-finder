package com.example.filmeFinder;

import com.example.filmeFinder.data.mongoRepository.MovieRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.filmeFinder.data.gateway.SearchMovieGateway;

@SpringBootApplication
@RestController
@EnableMongoRepositories(basePackageClasses = MovieRepository.class)
public class FilmeFinderApplication {

	@RequestMapping("/")
	public String home() {
		try {
			var gateway = new SearchMovieGateway();
			var movies = gateway.searchMovie("11");
			return movies.toString();
		} catch (Exception e) {
			System.err.print(e);
			return e.getMessage();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(FilmeFinderApplication.class, args);
	}

}
