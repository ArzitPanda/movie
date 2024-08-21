package com.arz.movie.controllers;

import com.arz.movie.dtos.bookings.BookingRequestDto;
import com.arz.movie.dtos.bookings.BookingResponseDto;
import com.arz.movie.models.enums.Status;
import com.arz.movie.services.bookingService.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingResponseDto> createBooking(@RequestBody BookingRequestDto bookingRequestDto) {
        BookingResponseDto bookingResponseDto = bookingService.createBooking(bookingRequestDto);
        return ResponseEntity.ok(bookingResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingResponseDto> getBookingById(@PathVariable Long id) {
        BookingResponseDto bookingResponseDto = bookingService.getBookingById(id);
        return ResponseEntity.ok(bookingResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<BookingResponseDto>> getAllBookings() {
        List<BookingResponseDto> bookingResponseDtos = bookingService.getAllBookings();
        return ResponseEntity.ok(bookingResponseDtos);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<BookingResponseDto> updateBookingStatus(@PathVariable Long id, @RequestParam Status status) {
        BookingResponseDto bookingResponseDto = bookingService.updateBookingStatus(id, status);
        return ResponseEntity.ok(bookingResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
