package com.arz.movie.dtos.screens.seats;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpacePresentSeats {
            String rowName;
            int rowPosition;
            boolean isSpaceLeft;
            boolean isSpaceRight;

}
