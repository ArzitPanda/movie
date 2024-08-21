package com.arz.movie.services.screenService;

import com.arz.movie.dtos.screens.AddSeatsScreen;
import com.arz.movie.dtos.screens.ScreenRequest;
import com.arz.movie.dtos.screens.seats.SeatsRange;
import com.arz.movie.dtos.screens.seats.SpacePresentSeats;
import com.arz.movie.models.MovieHall;
import com.arz.movie.models.Screen;
import com.arz.movie.models.Seat;
import com.arz.movie.repositories.MovieHallRepository;
import com.arz.movie.repositories.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@Service
public class ScreenServiceImpl implements  ScreenService{
  @Autowired
   MovieHallRepository movieHallRepository;


  @Autowired
    ScreenRepository screenRepository;

    @Override
    public String createScreen(ScreenRequest screenRequest) {
        Screen screen =new Screen();
        screen.setScreenName(screenRequest.getScreenName());


       MovieHall hall = movieHallRepository.findById(screenRequest.getHallId()).get();
        screen.setMovieHall(hall);

       if(hall.getScreens() ==null)
       {
           hall.setScreens(new ArrayList<>());
       }
       hall.getScreens().add(screen);
     MovieHall savedMovieHall =  movieHallRepository.save(hall);

     return "sucessfully added";

    }

    @Override
    public Screen getScreenById(Long id) {
        Screen fetchedScreen = screenRepository.findById(id).get();
        if(fetchedScreen!=null)
        {
            fetchedScreen.setSeats(fetchedScreen.getSeats());
        }
        return  fetchedScreen;
    }

    @Override
    public String addSeats(AddSeatsScreen addSeatsScreen) {
        Screen screen = screenRepository.findById(addSeatsScreen.getScreenId()).get();

        List<Seat> seats = new ArrayList<>();
        List<Seat> tempSeats = new ArrayList<>();

        addSeatsScreen.getSeatsRangeList().stream().forEach(ele->{

            List< SpacePresentSeats> spaces = ele.getSpacePresentSeats();

            for (int i = 1; i <=ele.getRange() ; i++) {
                Seat seat = new Seat();
                seat.setScreen(screen);
                seat.setSeatType(ele.getSeatType());
                seat.setRowName(ele.getRowName());
                seat.setNumber(i);
                seats.add(seat);
            }

        });
        if(screen.getSeats()!=null)
        {
            screen.getSeats().addAll(seats);
        }
        else
        {
            screen.setSeats(seats);
        }

        screenRepository.save(screen);
        return  "added sucessfully";



    }


}
