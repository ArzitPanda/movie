package com.arz.movie.controllers;


import com.arz.movie.dtos.moviehall.runningShow.movieslots.MovieSlotRequest;
import com.arz.movie.dtos.moviehall.runningShow.movieslots.SlotResponse;
import com.arz.movie.models.MovieSlot;
import com.arz.movie.services.slotservice.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("slots")
public class SlotController {

    @Autowired
    SlotService slotService;

    @PostMapping
    public List<MovieSlot> addAMovieSlots(@RequestBody List<MovieSlotRequest> movieSlotRequests)
    {
        List<MovieSlot> movieSlotList = slotService.AddSlotsForMovie(movieSlotRequests);
        return  movieSlotList;
    }
    @GetMapping("movies/{id}")
    public List<MovieSlot> getSlotsByMovieId(@PathVariable Long  id)
    {
        List<MovieSlot> movieSlotList = slotService.getAllSlotByMovieId(id);
        return  movieSlotList;
    }

    @GetMapping("runningShowa/{showId}/slots/{id}")
    public SlotResponse getSlotsByMovieId(@PathVariable Long showId,@PathVariable Long  id)
    {
       SlotResponse slotResponse = slotService.getMovieSlotById(showId,id);
        return  slotResponse;
    }


}
