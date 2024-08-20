package com.arz.movie.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "movieHall")
    private List<Screen> screens;

    @OneToMany(mappedBy = "movieHallAttached")
    private  List<RunningShow> runningShows;


}
