package com.arz.movie.services.bookingService;

import com.arz.movie.dtos.bookings.BookingRequestDto;
import com.arz.movie.dtos.bookings.BookingResponseDto;
import com.arz.movie.models.enums.Status;

import java.util.List;

public interface BookingService {
    BookingResponseDto createBooking(BookingRequestDto bookingRequestDto);
    BookingResponseDto getBookingById(Long id);
    List<BookingResponseDto> getAllBookings();
    BookingResponseDto updateBookingStatus(Long id, Status status);
    void deleteBooking(Long id);
}
