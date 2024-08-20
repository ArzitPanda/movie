package com.arz.movie.services.userService;

import com.arz.movie.dtos.users.UserRequest;
import com.arz.movie.dtos.users.UserResponse;
import com.arz.movie.exceptions.EntityNotFound;
import com.arz.movie.exceptions.EntityPresentException;

public interface UserService {

    UserResponse createUser(UserRequest user) throws EntityPresentException;
    UserResponse getUserById(Long userId) throws EntityNotFound;


}
