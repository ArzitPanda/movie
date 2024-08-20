package com.arz.movie.dtos.reviews;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponse {
    private Long id;
    private String movieName;
    private String userName;
    private String text;
    private Double rating;
}