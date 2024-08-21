package com.arz.movie.repositories;

import com.arz.movie.models.RunningShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RunningShowRepository extends JpaRepository<RunningShow,Long> {
    @Query("select r from RunningShow r where r.movie.id = ?1")
    List<RunningShow> getAlllRunningShowByMovieId(Long id);
}
