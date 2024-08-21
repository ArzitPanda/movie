package com.arz.movie.dtos.bookings;

import com.arz.movie.models.enums.Status;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class BookingResponseDto {
    private Long id;
    private Long userId;
    private Long movieSlotId;
    private List<Long> seatIds;
    private double price;
    private int quantity;
    private LocalDateTime createdAt;
    private Status status;
}

