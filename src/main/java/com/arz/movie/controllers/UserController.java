package com.arz.movie.controllers;


import com.arz.movie.dtos.users.UserRequest;
import com.arz.movie.dtos.users.UserResponse;
import com.arz.movie.services.userService.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id)
    {
        return ResponseEntity.ok( userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponse> saveUser(@RequestBody @Valid UserRequest userRequest, @AuthenticationPrincipal OAuth2User oAuth2User)
    {
        UserResponse user = null;
            user = userService.createUser(userRequest,oAuth2User.getName());
            return  ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
