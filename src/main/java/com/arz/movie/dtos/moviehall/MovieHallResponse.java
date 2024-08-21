package com.arz.movie.dtos.moviehall;


import com.arz.movie.models.RunningShow;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieHallResponse {
    private Long id;
    private String hallName;
    private String address;
    private Long pincode;
    private List<RunningShow> runningShows;
}
