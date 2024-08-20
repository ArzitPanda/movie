package com.arz.movie.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Movie.class)
    private  Movie movie;

    @ManyToOne(fetch =  FetchType.EAGER,targetEntity = User.class)
    private  User user;

    private String text;

    private Double rating;












}
