package com.arz.movie.dtos.reviews;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {
    private Long movieId;
    private Long userId;
    private String text;
    private Double rating;
}
