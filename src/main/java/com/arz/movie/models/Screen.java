package com.arz.movie.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Screen {

    @Id
    @GeneratedValue
    private Long id;

    private String ScreenName;

    @OneToMany(mappedBy = "screen")
    private List<Seat> seats;


    @ManyToOne
    private  MovieHall movieHall;


}
