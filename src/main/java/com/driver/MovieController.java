package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "movies")
public class MovieController {

    @Autowired// dependancy injection
    MovieService movieService;


    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie)
    {
        movieService.addMovie(movie);
        return new ResponseEntity<>("new Movie added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director)
    {
        movieService.addDirector(director);
        return new ResponseEntity<>("new director added successfully", HttpStatus.CREATED);

    }

    @PostMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movie, @RequestParam("director")String director)
    {
        movieService.createMovieDirectorPair(movie,director);
        return new ResponseEntity<>("Successfully",HttpStatus.CREATED);

    }
    @GetMapping("/get_movie_by_name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name)
    {
        Movie movies = movieService.findMovie(name);
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }

    @GetMapping("/get_director_by_name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name)
    {
        Director director = movieService.findDirector(name);
        return new ResponseEntity<>(director,HttpStatus.CREATED);
    }

    @GetMapping("/get_movie_by_director_name/{name}")
    public ResponseEntity<List<String>> getMoviesByDirectorByName(@PathVariable String director)
    {
        List<String> movies = movieService.findMoviesFromDirector(director);
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }

    @GetMapping("/get_all_movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> movies =movieService.findAllMovies();
        return new ResponseEntity<>(movies,HttpStatus.OK);
    }

    @DeleteMapping("/delete_director_by_name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director)
    {
        movieService.deleteDirector(director);
        return new ResponseEntity<>(director+"Removed successfully",HttpStatus.CREATED);
    }

    @DeleteMapping("/delete_all_director")
    public ResponseEntity<String> deleteAllDirector()
    {
        movieService.deleteAllDirector();
        return new ResponseEntity<>(" All Removed successfully",HttpStatus.CREATED);
    }

    @GetMapping("/get_director_by_movie_name")
    public ResponseEntity<String> getDirectorByMoviesName(@RequestParam String movie)
    {
        String s =  movieService.findDirectorFromMovies(movie);
        return new ResponseEntity<>(s,HttpStatus.CREATED);
    }

}
