package com.arz.movie.dtos.casts;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CastRequest {
    private String name;
    private String altername;
    private String[] designations;
    private LocalDate dateOfBirth;
    private String birthPlace;
    private String desc;
}

