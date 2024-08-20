package com.arz.movie.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seat {

    @Id
    @GeneratedValue
    private  Long id;

    private String seatType;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Screen.class)
    private  Screen screen;



}
