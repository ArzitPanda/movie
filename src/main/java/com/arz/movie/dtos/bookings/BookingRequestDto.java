package com.arz.movie.dtos.bookings;

import com.arz.movie.models.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequestDto {
    private Long userId;
    private Long movieSlotId;
    private List<Long> seatIds;
    private double price;
    private int quantity;
    private Status status;
}
