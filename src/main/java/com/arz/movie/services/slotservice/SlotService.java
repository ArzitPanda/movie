package com.arz.movie.services.slotservice;

import com.arz.movie.dtos.moviehall.runningShow.movieslots.MovieSlotRequest;
import com.arz.movie.models.MovieSlot;

import java.util.List;

public interface SlotService {

    public List<MovieSlot> AddSlotsForMovie(List<MovieSlotRequest> request);

    public  List<MovieSlot> getAllSlotByMovieId(Long movieId);






}
