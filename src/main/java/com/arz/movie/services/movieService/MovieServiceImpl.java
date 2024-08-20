package com.arz.movie.services.movieService;



import com.arz.movie.dtos.casts.CastResponse;
import com.arz.movie.dtos.movies.MovieRequest;
import com.arz.movie.dtos.movies.MovieResponse;
import com.arz.movie.models.Cast;
import com.arz.movie.models.Movie;
import com.arz.movie.repositories.CastRepository;

import com.arz.movie.repositories.MovieRepository;
import com.arz.movie.utils.FileUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CastRepository castRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MovieResponse createMovie(MovieRequest movieRequest) {
        Movie movie = modelMapper.map(movieRequest, Movie.class);

        movie.setImages(FileUtils.convertToBytes(movieRequest.getImage()));
        movie.setTrailer(FileUtils.convertToBytes(movieRequest.getTrailer()));

        List<Cast> casts = castRepository.findAllById(movieRequest.getCastIds());
        movie.setCasts(casts);

        movie = movieRepository.save(movie);
        return mapToResponse(movie);
    }

    @Override
    public MovieResponse getMovieById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        return mapToResponse(movie);
    }

    @Override
    public List<MovieResponse> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public MovieResponse updateMovie(Long id, MovieRequest movieRequest) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        modelMapper.map(movieRequest, movie);

        movie.setImages(FileUtils.convertToBytes(movieRequest.getImage()));
        movie.setTrailer(FileUtils.convertToBytes(movieRequest.getTrailer()));

        List<Cast> casts = castRepository.findAllById(movieRequest.getCastIds());
        movie.setCasts(casts);
        movie = movieRepository.save(movie);
        return mapToResponse(movie);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }



    private MovieResponse mapToResponse(Movie movie) {
        MovieResponse movieResponse = modelMapper.map(movie, MovieResponse.class);

        // Convert byte[] to Base64 encoded string
        movieResponse.setImageBase64(movie.getImages() != null ? Base64.getEncoder().encodeToString(movie.getImages()) : null);
        movieResponse.setTrailerBase64(movie.getTrailer() != null ? Base64.getEncoder().encodeToString(movie.getTrailer()) : null);

        movieResponse.setCastNames(movie.getCasts().stream().map((element) -> modelMapper.map(element, CastResponse.class))
                .collect(Collectors.toList()));

        if(movie.getReviews()!=null )
        movieResponse.setReviewComments(movie.getReviews().stream()
                .map(review -> review)
                .collect(Collectors.toList()));
        else
            movieResponse.setReviewComments(new ArrayList<>());

        return movieResponse;
    }
}
