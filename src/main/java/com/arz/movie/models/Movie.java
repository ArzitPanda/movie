package com.arz.movie.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;



@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private byte[] images;
    private byte[] trailer;
    private String movieType;
    private String movieLanguage;
    private int  durationInSeconds;
    private String[] genre;
    private LocalDate releasedDate;
    private String description;

    @ManyToMany(cascade = CascadeType.DETACH,fetch = FetchType.LAZY)
    private List<Cast> casts;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private  List<Review> reviews;



}
