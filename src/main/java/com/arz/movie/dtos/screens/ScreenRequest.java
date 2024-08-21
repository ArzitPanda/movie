package com.arz.movie.dtos.screens;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScreenRequest {

    private Long hallId;
    private String ScreenName;


}
