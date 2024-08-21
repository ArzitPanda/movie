package com.arz.movie.services.movieHallService;

import com.arz.movie.dtos.moviehall.MovieHallRequest;
import com.arz.movie.dtos.moviehall.MovieHallResponse;
import com.arz.movie.dtos.moviehall.runningShow.RunningShowAddRequest;

public interface MovieHallService {
    MovieHallResponse createMovieHall(MovieHallRequest movieHallRequest);

    String addShowsToMovieHall(RunningShowAddRequest runningShowAddRequest);

}
