package com.arz.movie.mapper;

import com.arz.movie.dtos.reviews.ReviewResponse;
import com.arz.movie.models.Review;

public class ReviewMapper {
    public static ReviewResponse mapToResponse(Review review) {
        ReviewResponse reviewResponse = new ReviewResponse();
        reviewResponse.setText(review.getText());
        reviewResponse.setRating(reviewResponse.getRating());
        reviewResponse.setId(review.getId());
        reviewResponse.setMovieName(review.getMovie().getName());
        reviewResponse.setUserName(review.getUser().getFirstName());
        return reviewResponse;
    }
}
