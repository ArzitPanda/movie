package com.arz.movie.dtos.users;

import com.arz.movie.models.enums.Gender;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.arz.movie.models.User}
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest implements Serializable {
    String firstName;
    String lastName;
    @NotNull(message = "can not be null")
    @NotEmpty
    String mobileNumber;
    LocalDate dob;
    Gender gender;
}