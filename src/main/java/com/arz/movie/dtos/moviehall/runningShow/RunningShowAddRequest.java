package com.arz.movie.dtos.moviehall.runningShow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RunningShowAddRequest {

    private Long movieId;
    private Long movieHallId;

}
