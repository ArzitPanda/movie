package com.arz.movie.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieSlot {

    @Id
    @GeneratedValue
    private  Long id;
    @ManyToOne
    @JoinColumn(name = "screen_id")
    private  Screen screen;


    private LocalDateTime showStartDateAndTime;

    List<Long> unavaliableSeats =new ArrayList<>();


}
