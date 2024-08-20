package com.arz.movie.controllers;


import com.arz.movie.dtos.reviews.ReviewRequest;
import com.arz.movie.dtos.reviews.ReviewResponse;
import com.arz.movie.services.reviewService.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewResponse> createReview(@RequestBody ReviewRequest reviewRequest) {
        ReviewResponse reviewResponse = reviewService.createReview(reviewRequest);
        return ResponseEntity.ok(reviewResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponse> getReviewById(@PathVariable Long id) {
        ReviewResponse reviewResponse = reviewService.getReviewById(id);
        return ResponseEntity.ok(reviewResponse);
    }

    @GetMapping
    public ResponseEntity<List<ReviewResponse>> getAllReviews() {
        List<ReviewResponse> reviewResponses = reviewService.getAllReviews();
        return ResponseEntity.ok(reviewResponses);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}
