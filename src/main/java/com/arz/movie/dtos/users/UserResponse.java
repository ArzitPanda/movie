package com.arz.movie.dtos.users;

import com.arz.movie.models.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.arz.movie.models.User}
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserResponse implements Serializable {
    Long id;
    String firstName;
    String lastName;
    String mobileNumber;
    LocalDate dob;
    Gender gender;
}