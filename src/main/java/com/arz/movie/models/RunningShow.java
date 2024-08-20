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
public class RunningShow {

    @Id
    @GeneratedValue
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id")
    private  Movie movie;

    @ManyToOne
    @JoinColumn(name = "movie_hall_id")
    private  MovieHall movieHallAttached;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    List<MovieSlot> movieSlotList;


}
