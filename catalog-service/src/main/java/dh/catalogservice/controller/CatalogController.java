package dh.catalogservice.controller;

import dh.catalogservice.dto.MovieDTO;
import dh.catalogservice.feignClient.MovieClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatalogController {
    @Autowired
    private MovieClient movieClient;

    @GetMapping("/{genere}")
    public ResponseEntity<List<MovieDTO>> getByGenere(@PathVariable String genere) {
        return ResponseEntity.ok(movieClient.getMoviesByGenere(genere));
    }
}
