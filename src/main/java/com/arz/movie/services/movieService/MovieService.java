package com.arz.movie.services.movieService;

import com.arz.movie.dtos.movies.MovieRequest;
import com.arz.movie.dtos.movies.MovieResponse;

import java.util.List;

public interface MovieService {
    MovieResponse createMovie(MovieRequest movieRequest);
    MovieResponse getMovieById(Long id);
    List<MovieResponse> getAllMovies();
    MovieResponse updateMovie(Long id, MovieRequest movieRequest);
    void deleteMovie(Long id);
}
