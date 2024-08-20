package com.arz.movie.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movie_actors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cast {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  String name;
    private String altername;

    private  String[] designations;

    private LocalDate dateOfBirth;
    private String  birthPlace;

    @Column(name = "description",length = 500)
    private String desc;


    @ManyToMany(mappedBy = "casts")
    private List<Movie> movies;


}
