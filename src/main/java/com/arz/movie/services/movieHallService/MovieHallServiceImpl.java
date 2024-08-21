package com.arz.movie.services.movieHallService;

import com.arz.movie.dtos.moviehall.MovieHallRequest;
import com.arz.movie.dtos.moviehall.MovieHallResponse;
import com.arz.movie.dtos.moviehall.runningShow.RunningShowAddRequest;
import com.arz.movie.models.Movie;
import com.arz.movie.models.MovieHall;
import com.arz.movie.models.RunningShow;
import com.arz.movie.repositories.MovieHallRepository;
import com.arz.movie.repositories.MovieRepository;
import com.arz.movie.repositories.RunningShowRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieHallServiceImpl implements  MovieHallService {
    @Autowired
    private MovieHallRepository movieHallRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    private RunningShowRepository runningShowRepository;


    @Override
    public MovieHallResponse createMovieHall(MovieHallRequest movieHallRequest) {
        MovieHall movieHall = modelMapper.map(movieHallRequest, MovieHall.class);
        MovieHall savedMovieHall = movieHallRepository.save(movieHall);

        return modelMapper.map(savedMovieHall, MovieHallResponse.class);
    }

    @Override
    public String addShowsToMovieHall(RunningShowAddRequest runningShowAddRequest) {

      MovieHall movieHall=  movieHallRepository.findById(runningShowAddRequest.getMovieHallId()).orElse(null);
      Movie movie =movieRepository.findById(runningShowAddRequest.getMovieId()).orElse(null);
        List<RunningShow> runningShowList = movieHall.getRunningShows();

       List<RunningShow> runningShows= runningShowList.stream().filter(ele->ele.getMovie().getId()==runningShowAddRequest.getMovieId()).toList();
        if(runningShowList.size()==0 ||  runningShows.size()==0)
        {
            RunningShow runningShow = new RunningShow();
            runningShow.setMovieHallAttached(movieHall);
            runningShow.setMovie(movie);
           
            runningShow.setMovieSlotList(new ArrayList<>());
            movieHall.getRunningShows().add(runningShow);

            movieHallRepository.save(movieHall);
             return "added sucessfully"+runningShow.getId();
        }
        else
        {
                 return "Something went wrong";
        }



    }
}
