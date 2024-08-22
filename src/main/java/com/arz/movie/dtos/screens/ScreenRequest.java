package com.arz.movie.dtos.screens;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScreenRequest {

    private Long hallId;
    private String ScreenName;
    private HashMap<String,Double> defaultPrice;


}
