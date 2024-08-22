package com.arz.movie.dtos.moviehall.runningShow.movieslots;

import com.arz.movie.models.MovieSlot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SlotResponse {

    Map<String ,Double> slotprices;
    MovieSlot movieSlot;

}
