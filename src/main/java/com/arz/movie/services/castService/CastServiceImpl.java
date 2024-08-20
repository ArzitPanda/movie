package com.arz.movie.services.castService;

import com.arz.movie.dtos.casts.CastRequest;
import com.arz.movie.dtos.casts.CastResponse;
import com.arz.movie.exceptions.EntityNotFound;
import com.arz.movie.models.Cast;
import com.arz.movie.repositories.CastRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CastServiceImpl implements CastService {

    @Autowired
    private CastRepository castRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CastResponse createCast(CastRequest castRequest) {
        Cast cast = modelMapper.map(castRequest, Cast.class);
        cast = castRepository.save(cast);
        return modelMapper.map(cast, CastResponse.class);
    }

    @Override
    public CastResponse getCastById(Long id) {
        Cast cast = castRepository.findById(id).orElseThrow(() -> new EntityNotFound("Cast"));
        return modelMapper.map(cast, CastResponse.class);
    }

    @Override
    public List<CastResponse> getAllCasts() {
        return castRepository.findAll().stream()
                .map(cast -> modelMapper.map(cast, CastResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public CastResponse updateCast(Long id, CastRequest castRequest) {
        Cast cast = castRepository.findById(id).orElseThrow(() -> new EntityNotFound("Cast"));
        modelMapper.map(castRequest, cast);
        cast = castRepository.save(cast);
        return modelMapper.map(cast, CastResponse.class);
    }

    @Override
    public void deleteCast(Long id) {
        castRepository.deleteById(id);
    }
}

