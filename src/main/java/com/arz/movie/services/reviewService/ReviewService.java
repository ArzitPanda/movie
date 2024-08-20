package com.arz.movie.services.reviewService;

import com.arz.movie.dtos.reviews.ReviewRequest;
import com.arz.movie.dtos.reviews.ReviewResponse;

import java.util.List;

public interface ReviewService {
    ReviewResponse createReview(ReviewRequest reviewRequest);
    ReviewResponse getReviewById(Long id);
    List<ReviewResponse> getAllReviews();
    void deleteReview(Long id);
}
