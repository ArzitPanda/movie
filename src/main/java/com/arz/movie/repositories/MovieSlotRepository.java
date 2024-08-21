package com.arz.movie.repositories;

import com.arz.movie.models.MovieSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieSlotRepository extends JpaRepository<MovieSlot,Long> {

    @Query(
            value = "select ms from movie_slot as ms " +
                    " join running_show_movie_slot_list as jt on ms.id=jt.movie_slot_list_id " +
                    "inner join running_show as rs on rs.id=jt.running_show_id " +
                    "WHERE rs.movie_id = :movieId",nativeQuery = true
    )
    List<MovieSlot> findMovieSlotsByMovieIdAndMovieHallId(@Param("movieId") Long movieId);
}
