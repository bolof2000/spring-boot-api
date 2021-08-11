package com.example.demo.controller;

import com.example.demo.entity.ThemeParkRide;
import com.example.demo.repository.ThemeParkRespository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ThemeParkRideController {

    private final ThemeParkRespository themeParkRespository;

    public ThemeParkRideController(ThemeParkRespository themeParkRespository){
        this.themeParkRespository = themeParkRespository;
    }

    @GetMapping(value="/ride",produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ThemeParkRide> getRides(){
        return themeParkRespository.findAll();
    }


    @PostMapping(value = "/ride",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ThemeParkRide createRide(@Validated @RequestBody ThemeParkRide themeParkRide){
        return themeParkRespository.save(themeParkRide);
    }



}
