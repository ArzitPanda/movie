package com.arz.movie.services.reviewService;

import com.arz.movie.dtos.reviews.ReviewRequest;
import com.arz.movie.dtos.reviews.ReviewResponse;
import com.arz.movie.models.Movie;
import com.arz.movie.models.Review;
import com.arz.movie.models.User;
import com.arz.movie.repositories.MovieRepository;
import com.arz.movie.repositories.ReviewRepository;
import com.arz.movie.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.arz.movie.mapper.ReviewMapper.mapToResponse;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ReviewResponse createReview(ReviewRequest reviewRequest) {
        Movie movie = movieRepository.findById(reviewRequest.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        User user = userRepository.findById(reviewRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Review review = new Review();
        review.setText(reviewRequest.getText());
        review.setRating(reviewRequest.getRating());
        review.setMovie(movie);
        review.setUser(user);

        review = reviewRepository.save(review);
        return mapToResponse(review);
    }

    @Override
    public ReviewResponse getReviewById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        return mapToResponse(review);
    }

    @Override
    public List<ReviewResponse> getAllReviews() {
        return reviewRepository.findAll().stream()
                .map(ele->mapToResponse(ele))
                .collect(Collectors.toList());
    }

    public ReviewResponse updateReview(Long id, ReviewRequest reviewRequest) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));

        Movie movie = movieRepository.findById(reviewRequest.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        User user = userRepository.findById(reviewRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        review.setMovie(movie);
        review.setUser(user);
        review.setText(reviewRequest.getText());
        review.setRating(reviewRequest.getRating());

        review = reviewRepository.save(review);
        return mapToResponse(review);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }


}
