package com.example.filmeFinder;

import java.util.List;

import com.example.filmeFinder.data.model.Movie;
import com.example.filmeFinder.data.repository.MovieRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MovieController {

  private final MovieRepository repository;

  public MovieController(MovieRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/movie")
  List<Movie> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/movie")
  Movie newMovie(@RequestBody Movie newMovie) {
    return repository.save(newMovie);
  }

  // Single item
  
  @GetMapping("/movie/{id}")
  Movie one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new MovieNotFoundException(id));
  }

  @PutMapping("/movie/{id}")
  Movie replaceMovie(@RequestBody Movie newMovie, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(movie -> {
        movie.setName(newMovie.getName());
        return repository.save(movie);
      })
      .orElseGet(() -> {
        newMovie.setId(id);
        return repository.save(newMovie);
      });
  }

  @DeleteMapping("/movie/{id}")
  void deleteMovie(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
