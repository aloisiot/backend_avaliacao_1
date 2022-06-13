package dh.moviesservice.controller;

import dh.moviesservice.model.Movie;
import dh.moviesservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieRepository repository;

    @GetMapping("/{genere}")
    public ResponseEntity<List<Movie>> findByGenere(@PathVariable String genere) {
        return ResponseEntity.ok(repository.findByGenere(genere));
    }

    @PostMapping
    public ResponseEntity<Movie> save(@RequestBody Movie movie) {
        return ResponseEntity.ok(repository.save(movie));
    }
}
