package com.arz.movie.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Screen {

    @Id
    @GeneratedValue
    private Long id;

    private String ScreenName;

    @OneToMany(mappedBy = "screen",cascade = CascadeType.ALL)
    private List<Seat> seats;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH)
    private  MovieHall movieHall;


    @ElementCollection
    Map<String,Double> defaultPrice = new HashMap<>();


}
