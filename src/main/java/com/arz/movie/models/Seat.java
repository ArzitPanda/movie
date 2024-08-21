package com.arz.movie.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private String rowName;

    private  int number;

    @Column(columnDefinition = "boolean default false")
    private  Boolean isSpaceLeft;

    @Column(columnDefinition = "boolean default false")
    private  Boolean isSpaceRight;

    private String seatType;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Screen.class)
    private  Screen screen;





}
