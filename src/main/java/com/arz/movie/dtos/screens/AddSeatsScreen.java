package com.arz.movie.dtos.screens;


import com.arz.movie.dtos.screens.seats.SeatsRange;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddSeatsScreen {

private long screenId;
private List<SeatsRange> seatsRangeList;

}
