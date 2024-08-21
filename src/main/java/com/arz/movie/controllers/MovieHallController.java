package com.arz.movie.controllers;

import com.arz.movie.dtos.moviehall.MovieHallRequest;
import com.arz.movie.dtos.moviehall.MovieHallResponse;
import com.arz.movie.dtos.moviehall.runningShow.RunningShowAddRequest;
import com.arz.movie.dtos.screens.AddSeatsScreen;
import com.arz.movie.dtos.screens.ScreenRequest;
import com.arz.movie.models.Screen;
import com.arz.movie.services.movieHallService.MovieHallService;
import com.arz.movie.services.screenService.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("moviehalls")
public class MovieHallController {

    @Autowired
    private MovieHallService movieHallService;

    @Autowired
    private ScreenService screenService;

    @PostMapping
    public MovieHallResponse createMovieHall(@RequestBody MovieHallRequest movieHallRequest) {
        return movieHallService.createMovieHall(movieHallRequest);
    }

    @PostMapping("screens")
    public ResponseEntity<String> addScreen(@RequestBody ScreenRequest screenRequest)
    {
       String a =  screenService.createScreen(screenRequest);
       return  ResponseEntity.ok(a);
    }


    @PostMapping("screens/seats")
    public ResponseEntity<String> addSeats(@RequestBody AddSeatsScreen addSeatsScreen)
    {
        String a =  screenService.addSeats(addSeatsScreen);
        return  ResponseEntity.ok(a);
    }


    @PutMapping("screens/runningshow")
    public ResponseEntity<String> addRunningShow(RunningShowAddRequest runningShowAddRequest)
    {
        String a = movieHallService.addShowsToMovieHall(runningShowAddRequest);
        return  ResponseEntity.ok(a);

    }

    @GetMapping("screens/{id}")
    public  ResponseEntity<Screen> getScreensById(@PathVariable Long id)
    {
        Screen a= screenService.getScreenById(id);
        return  ResponseEntity.ok(a);
    }
}