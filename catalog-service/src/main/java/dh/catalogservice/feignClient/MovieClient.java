package dh.catalogservice.feignClient;

import dh.catalogservice.dto.MovieDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "movies-service")
public interface MovieClient {

    @GetMapping("/movies/{genere}")
    public List<MovieDTO> getMoviesByGenere(@PathVariable String genere);
}
