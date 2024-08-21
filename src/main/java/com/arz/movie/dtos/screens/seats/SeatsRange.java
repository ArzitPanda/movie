package com.arz.movie.dtos.screens.seats;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatsRange {
    private  String rowName;
    private  String seatType;
    private   int range;
    private List<SpacePresentSeats> spacePresentSeats;
}
