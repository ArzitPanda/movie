package com.arz.movie.controllers;

import com.arz.movie.dtos.movies.MovieRequest;
import com.arz.movie.dtos.movies.MovieResponse;
import com.arz.movie.services.movieService.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<MovieResponse> createMovie(
            @RequestPart("image") MultipartFile image,
            @RequestPart("trailer") MultipartFile trailer,
            @RequestParam("name") String name,
            @RequestParam("movieType") String movieType,
            @RequestParam("movieLanguage") String movieLanguage,
            @RequestParam("durationInSeconds") int durationInSeconds,
            @RequestParam("genre") String[] genre,
            @RequestParam("releasedDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate releasedDate,
            @RequestParam("description") String description,
            @RequestParam("castIds") List<Long> castIds) {

        MovieRequest movieRequest = new MovieRequest(
                name, image, trailer, movieType, movieLanguage, durationInSeconds, genre, releasedDate, description, castIds);

        MovieResponse movieResponse = movieService.createMovie(movieRequest);
        return ResponseEntity.ok(movieResponse);
    }


    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> getMovieById(@PathVariable Long id) {
        MovieResponse movieResponse = movieService.getMovieById(id);
        return ResponseEntity.ok(movieResponse);
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> getAllMovies() {
        List<MovieResponse> movieResponses = movieService.getAllMovies();
        return ResponseEntity.ok(movieResponses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> updateMovie(
            @PathVariable Long id,
            @RequestPart("name") String name,
            @RequestPart("movieType") String movieType,
            @RequestPart("movieLanguage") String movieLanguage,
            @RequestPart("durationInSeconds") int durationInSeconds,
            @RequestPart("genre") String[] genre,
            @RequestPart("releasedDate") LocalDate releasedDate,
            @RequestPart("description") String description,
            @RequestPart("castIds") List<Long> castIds,
            @RequestPart("image") MultipartFile image,
            @RequestPart("trailer") MultipartFile trailer) {

        MovieRequest movieRequest = new MovieRequest(
                name, image, trailer, movieType, movieLanguage, durationInSeconds, genre, releasedDate, description, castIds);

        MovieResponse movieResponse = movieService.updateMovie(id, movieRequest);
        return ResponseEntity.ok(movieResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
