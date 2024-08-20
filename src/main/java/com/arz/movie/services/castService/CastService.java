package com.arz.movie.services.castService;



import com.arz.movie.dtos.casts.CastRequest;
import com.arz.movie.dtos.casts.CastResponse;

import java.util.List;
public interface CastService {
    CastResponse createCast(CastRequest castRequest);
    CastResponse getCastById(Long id);
    List<CastResponse> getAllCasts();
    CastResponse updateCast(Long id, CastRequest castRequest);
    void deleteCast(Long id);
}
