package com.arz.movie.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private  List<Review> reviews;


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", movieType='" + movieType + '\'' +
                ", movieLanguage='" + movieLanguage + '\'' +
                ", durationInSeconds=" + durationInSeconds +
                ", genre=" + Arrays.toString(genre) +
                ", releasedDate=" + releasedDate +
                ", description='" + description + '\'' +
                ", reviews=" + reviews +
                ", casts=" + casts +
                '}';
    }
}
