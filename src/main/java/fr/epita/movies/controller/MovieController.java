package fr.epita.movies.controller;


import fr.epita.movies.domain.Movie;

import fr.epita.movies.exception.ResourceException;
import fr.epita.movies.repository.MovieRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;
    private static final Logger LOGGER = LogManager.getLogger(MovieController.class);

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        LOGGER.info("Get All Movies {}", movieRepository.findAll());
        return movieRepository.findAll();
    }

    //POST movie rest api
    @PostMapping("/movies")
    public Movie createMovie(@RequestBody Movie movie){
        return movieRepository.save(movie);
    }

    //GET movie by ID
    @GetMapping("/movies/{id}")
    public ResponseEntity< Movie> getMovieById(@PathVariable Long id){
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceException("Movie of id: "+id +" does not exist"));
        return ResponseEntity.ok(movie);

    }

    //PUT movie rest api
    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movieInfo){
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceException("Movie of id: "+id +" does not exist"));

        movie.setName(movieInfo.getName());
        movie.setCategory(movieInfo.getCategory());
        movie.setPoster(movieInfo.getPoster());
        movie.setRelease(movieInfo.getRelease());
        movie.setDescription(movieInfo.getDescription());

        Movie updatedMovie = movieRepository.save(movie);
        return ResponseEntity.ok(updatedMovie);
    }

    //DELETE movie
    @DeleteMapping("/movies/{id}")
    public ResponseEntity <Map<String, Boolean>> deleteMovie(@PathVariable Long id){
        Movie movie= movieRepository.findById(id)
                .orElseThrow(() -> new ResourceException("Movie of id: \"+id +\" does not exist"));
        movieRepository.delete(movie);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}