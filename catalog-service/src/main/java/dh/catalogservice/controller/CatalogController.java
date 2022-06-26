package dh.catalogservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dh.catalogservice.dto.MovieDTO;
import dh.catalogservice.feignClient.MovieClient;
import dh.catalogservice.messaging.QueueSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatalogController {
    @Autowired
    private MovieClient movieClient;

    @Autowired
    private QueueSender queueSender;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/{genere}")
    public ResponseEntity<List<MovieDTO>> getByGenere(@PathVariable String genere) {
        return ResponseEntity.ok(movieClient.getMoviesByGenere(genere));
    }

    @PostMapping(value = { "/addMovie", "add-movie" }, produces = "application/json")
    public ResponseEntity<String> addMovie(@RequestBody MovieDTO movie) throws JsonProcessingException {
        queueSender.send(objectMapper.writeValueAsString(movie));
        return ResponseEntity.ok("{\n\t\"message\": \"Request received\"\n}");
    }
}
