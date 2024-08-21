package com.arz.movie.dtos.moviehall.runningShow.movieslots;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieSlotRequest {

    private Long runningShowId;
    private  Long screenId;

    private LocalDateTime showStart;

}
