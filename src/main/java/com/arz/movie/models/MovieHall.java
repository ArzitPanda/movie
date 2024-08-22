package com.arz.movie.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieHall {

    @Id
    @GeneratedValue
    private  Long id;

    private String hallName;
    private String address;
    private Long pincode;

    @OneToMany(mappedBy = "movieHall",cascade = CascadeType.ALL)
    private List<Screen> screens;

    @OneToMany(mappedBy = "movieHallAttached",cascade = CascadeType.ALL)
    private  List<RunningShow> runningShows;





}
