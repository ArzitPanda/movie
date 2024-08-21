package com.arz.movie.services.slotservice;

import com.arz.movie.dtos.moviehall.runningShow.movieslots.MovieSlotRequest;
import com.arz.movie.exceptions.EntityNotFound;
import com.arz.movie.models.MovieSlot;
import com.arz.movie.models.RunningShow;
import com.arz.movie.models.Screen;
import com.arz.movie.repositories.MovieSlotRepository;
import com.arz.movie.repositories.RunningShowRepository;
import com.arz.movie.repositories.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SlotServiceImpl implements  SlotService {


    @Autowired
    MovieSlotRepository movieSlotRepository;

    @Autowired
    ScreenRepository screenRepository;

    @Autowired
    RunningShowRepository runningShowRepository;

    @Override
    public List<MovieSlot> AddSlotsForMovie(List<MovieSlotRequest> request) {

        List<MovieSlot> movieSlotList = new ArrayList<>();
        request.stream().forEach((ele)->{
            RunningShow runningShow = runningShowRepository.findById(ele.getRunningShowId()).orElse(null);

            Screen screen = screenRepository.findById(ele.getScreenId()).orElse(null);
            MovieSlot movieSlot = new MovieSlot();
            movieSlot.setScreen(screen);
            movieSlot.setShowStartDateAndTime(ele.getShowStart());
            movieSlot.setUnavaliableSeats(new ArrayList<>());
            runningShow.getMovieSlotList().add(movieSlot);

            runningShowRepository.save(runningShow);
            movieSlotList.add(movieSlot);

        });

        return  movieSlotList;


    }

    @Override
    public List<MovieSlot> getAllSlotByMovieId(Long movieId) {

        List<MovieSlot> movieSlots=runningShowRepository.getAlllRunningShowByMovieId(movieId).stream().flatMap(ele->ele.getMovieSlotList().stream()).toList();
        return  movieSlots;
    }
}
