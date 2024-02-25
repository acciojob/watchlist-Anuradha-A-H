package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepo;
    public void addMovie(Movie movie)
    {
        movieRepo.saveMovie(movie);
    }

    public void addDirector(Director director){
        movieRepo.saveDirector(director);
    }

    public void createMovieDirectorPair(String movie,String director)
    {
        movieRepo.saveMovieDirectorPair(movie,director);
    }

    public Movie findMovie(String MovieName)
    {
        return movieRepo.findMovie(MovieName);
    }
    public Director findDirector(String directorName)
    {
        return movieRepo.findDirector(directorName);
    }
    public List<String> findMoviesFromDirector(String director)
    {
        return movieRepo.findMoviesFromDirector(director);
    }

    public List<String> findAllMovies()
    {


        return movieRepo.findAllMovies();
    }

    public void deleteDirector(String dir)
    {
        movieRepo.deleteDirector(dir);

    }

    public void deleteAllDirector()
    {
        movieRepo.deleteAllDirector();
    }

    public String findDirectorFromMovies(String mov)
    {
        return movieRepo.getDirectorofMovie(mov);
    }



}
