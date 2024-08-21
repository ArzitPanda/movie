package com.arz.movie.services.screenService;

import com.arz.movie.dtos.screens.AddSeatsScreen;
import com.arz.movie.dtos.screens.ScreenRequest;
import com.arz.movie.models.Screen;

import java.util.List;

public interface ScreenService {

    String createScreen(ScreenRequest screenRequest);

    Screen getScreenById(Long id);


    String addSeats(AddSeatsScreen addSeatsScreen);

}
