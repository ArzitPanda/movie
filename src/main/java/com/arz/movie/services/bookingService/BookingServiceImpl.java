package com.arz.movie.services.bookingService;

import com.arz.movie.dtos.bookings.BookingRequestDto;
import com.arz.movie.dtos.bookings.BookingResponseDto;
import com.arz.movie.models.Booking;
import com.arz.movie.models.MovieSlot;
import com.arz.movie.models.Seat;
import com.arz.movie.models.enums.Status;
import com.arz.movie.repositories.BookingRepository;
import com.arz.movie.repositories.MovieSlotRepository;
import com.arz.movie.repositories.SeatRepository;
import com.arz.movie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieSlotRepository movieSlotRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public BookingResponseDto createBooking(BookingRequestDto bookingRequestDto) {
        Booking booking = new Booking();



        booking.setUser(userRepository.findById(bookingRequestDto.getUserId()).orElseThrow(() -> new RuntimeException("User not found")));
        MovieSlot movieSlot =(movieSlotRepository.findById(bookingRequestDto.getMovieSlotId()).orElseThrow(() -> new RuntimeException("MovieSlot not found")));
        bookingRequestDto.getSeatIds().stream().forEach(ele->{
               if( movieSlot.getUnavaliableSeats().contains(ele))
               {
                   throw  new RuntimeException("seats are not available");
               }
        });


        movieSlot.getUnavaliableSeats().addAll(bookingRequestDto.getSeatIds());


        MovieSlot savedMovieSlot = movieSlotRepository.save(movieSlot);
        booking.setMovieSlot(savedMovieSlot);
        booking.setSeats(bookingRequestDto.getSeatIds().stream().map(id -> seatRepository.findById(id).orElseThrow(() -> new RuntimeException("Seat not found"))).collect(Collectors.toList()));
        booking.setPrice(bookingRequestDto.getPrice());
        booking.setQuantity(bookingRequestDto.getQuantity());
        booking.setStatus(bookingRequestDto.getStatus());
        booking.setCreatedAt(LocalDateTime.now());

        Booking savedBooking = bookingRepository.save(booking);
        return mapToDto(savedBooking);
    }

    @Override
    public BookingResponseDto getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
        return mapToDto(booking);
    }

    @Override
    public List<BookingResponseDto> getAllBookings() {
        return bookingRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public BookingResponseDto updateBookingStatus(Long id, Status status) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
        MovieSlot movieSlot = movieSlotRepository.findById(booking.getMovieSlot().getId()).orElseThrow(() -> new RuntimeException("MovieSlot not found"));
        switch (status)
        {
            case BOOKED,CLICKED_PAYMENT_METHOD,ONLY_CLICK_ON_SEATS:
              //  movieSlot.getUnavaliableSeats().addAll(booking.getSeats().stream().map(ele->ele.getId()).toList());
                break;

            case CANCELLED,PENDING,DESELECTED:
                movieSlot.getUnavaliableSeats().removeAll(booking.getSeats().stream().map(ele->ele.getId()).toList());
                break;
            default:
                System.out.println("invalid");
                break;

        }
        booking.setStatus(status);
        movieSlotRepository.save(movieSlot);
        Booking updatedBooking = bookingRepository.save(booking);
        return mapToDto(updatedBooking);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    private BookingResponseDto mapToDto(Booking booking) {
        BookingResponseDto bookingResponseDto = new BookingResponseDto();

        bookingResponseDto.setId(booking.getId());
        bookingResponseDto.setUserId(booking.getUser().getId());
        bookingResponseDto.setMovieSlotId(booking.getMovieSlot().getId());
        bookingResponseDto.setSeatIds(booking.getSeats().stream().map(Seat::getId).collect(Collectors.toList()));
        bookingResponseDto.setPrice(booking.getPrice());
        bookingResponseDto.setQuantity(booking.getQuantity());
        bookingResponseDto.setCreatedAt(booking.getCreatedAt());
        bookingResponseDto.setStatus(booking.getStatus());

        return bookingResponseDto;
    }
}
