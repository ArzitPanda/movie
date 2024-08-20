package com.arz.movie.models;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private  User user;

    @OneToOne
    private  Booking booking;

}
