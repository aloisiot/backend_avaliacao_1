package dh.moviesservice.repository;

import dh.moviesservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("select m from Movie m where m.genere = :genere")
    List<Movie> findByGenere(@Param("genere") String genere);
}