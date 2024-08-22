package com.arz.movie.services.PriceCalculationService;

import com.arz.movie.exceptions.EntityNotFound;
import com.arz.movie.models.MovieHall;
import com.arz.movie.models.MovieSlot;
import com.arz.movie.models.RunningShow;
import com.arz.movie.repositories.MovieHallRepository;
import com.arz.movie.repositories.MovieRepository;
import com.arz.movie.repositories.MovieSlotRepository;
import com.arz.movie.repositories.RunningShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CalculationService {


    @Autowired
    RunningShowRepository runningShowRepository;


    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieSlotRepository movieSlotRepository;

    @Autowired
    MovieHallRepository movieHallRepository;




    public Map<String,Double>  calculate(long runningShowid,long movieSlotId)
    {
        
        RunningShow runningShow = runningShowRepository.findById(runningShowid).get();
        

        Long seats_occupied = runningShow.getMovieSlotList().stream().flatMap(ele->ele.getUnavaliableSeats().stream()).count();
       
        MovieSlot movieSlot =movieSlotRepository.findById(movieSlotId).get();
       double totalSeats =movieSlot.getScreen().getSeats().size();
       
       double factor = seats_occupied/totalSeats;
       
       double multiplier = 1;
       
       if (factor<=0.2)
       {
           
               multiplier*=0.85;
       } else if (factor>0.2 &&factor<=0.5){

           multiplier*=1.2;
       }
       else if(factor >0.5 &&factor<=1)
       {
           multiplier*=1.7;
       }


        Map<String,Double> pricesDefault =  movieSlot.getScreen().getDefaultPrice();

        double finalMultiplier = multiplier;
        pricesDefault.keySet().stream().forEach(ele->{
           pricesDefault.put(ele,pricesDefault.get(ele)* finalMultiplier);
       });


        return  pricesDefault;
          



    }


}
