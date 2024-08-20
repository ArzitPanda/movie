package com.arz.movie.dtos.casts;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CastResponse {
    private Long id;
    private String name;
    private String altername;
    private String[] designations;
    private LocalDate dateOfBirth;
    private String birthPlace;
    private String desc;
}

