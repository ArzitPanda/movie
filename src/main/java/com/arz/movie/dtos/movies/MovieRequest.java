package com.arz.movie.dtos.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequest {
    private String name;
    private MultipartFile image;
    private MultipartFile trailer;
    private String movieType;
    private String movieLanguage;
    private int durationInSeconds;
    private String[] genre;
    private LocalDate releasedDate;
    private String description;
    private List<Long> castIds;
}
