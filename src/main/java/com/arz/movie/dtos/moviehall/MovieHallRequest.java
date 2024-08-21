package com.arz.movie.dtos.moviehall;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieHallRequest {
    private String hallName;
    private String address;
    private Long pincode;
}
