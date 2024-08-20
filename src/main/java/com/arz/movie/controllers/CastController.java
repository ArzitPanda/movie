package com.arz.movie.controllers;

import com.arz.movie.dtos.casts.CastRequest;
import com.arz.movie.dtos.casts.CastResponse;
import com.arz.movie.services.castService.CastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("casts")
public class CastController {

    @Autowired
    private CastService castService;

    @PostMapping
    public ResponseEntity<CastResponse> createCast(@RequestBody CastRequest castRequest) {
        CastResponse castResponse = castService.createCast(castRequest);
        return ResponseEntity.ok(castResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CastResponse> getCastById(@PathVariable Long id) {
        CastResponse castResponse = castService.getCastById(id);
        return ResponseEntity.ok(castResponse);
    }

    @GetMapping
    public ResponseEntity<List<CastResponse>> getAllCasts() {
        List<CastResponse> castResponses = castService.getAllCasts();
        return ResponseEntity.ok(castResponses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CastResponse> updateCast(@PathVariable Long id, @RequestBody CastRequest castRequest) {
        CastResponse castResponse = castService.updateCast(id, castRequest);
        return ResponseEntity.ok(castResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCast(@PathVariable Long id) {
        castService.deleteCast(id);
        return ResponseEntity.noContent().build();
    }
}
