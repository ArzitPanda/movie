package com.arz.movie.models;


import com.arz.movie.models.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue
    private  Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private  User user;

    private Status status;

    @OneToOne(cascade = CascadeType.ALL)
    private  MovieSlot movieSlot;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Seat> seats;

    private double price;

    private LocalDateTime createdAt;

    private int quantity;

}
