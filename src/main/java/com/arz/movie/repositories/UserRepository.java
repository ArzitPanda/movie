package com.arz.movie.repositories;

import com.arz.movie.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByMobileNumberIgnoreCase(String mobileNumber);

    Optional<User> findByOauthId(String oauthId);

    boolean existsByOauthId(String oauthId);
}
