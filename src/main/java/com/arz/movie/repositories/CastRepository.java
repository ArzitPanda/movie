package com.arz.movie.repositories;

import com.arz.movie.models.Cast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CastRepository extends JpaRepository<Cast, Long> {
}