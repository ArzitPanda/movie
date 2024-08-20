package com.arz.movie.dtos.movies;

import com.arz.movie.dtos.casts.CastResponse;
import com.arz.movie.models.Cast;
import com.arz.movie.models.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponse {
    private Long id;
    private String name;
    private String imageBase64;
    private String trailerBase64;
    private String movieType;
    private String movieLanguage;
    private int durationInSeconds;
    private String[] genre;
    private LocalDate releasedDate;
    private String description;
    private List<CastResponse> castNames;
    private List<Review> reviewComments;
}