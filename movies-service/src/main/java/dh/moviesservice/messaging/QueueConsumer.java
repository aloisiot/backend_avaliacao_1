package dh.moviesservice.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dh.moviesservice.model.Movie;
import dh.moviesservice.repository.MovieRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {

    @Autowired
    private MovieRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "${queue.name}")
    public void receive(@Payload String movie) throws JsonProcessingException {
        repository.save(objectMapper.readValue(movie, Movie.class));
    }
}
