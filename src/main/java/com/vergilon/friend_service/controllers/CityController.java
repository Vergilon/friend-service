package com.vergilon.friend_service.controllers;

import com.vergilon.friend_service.dto.CityDto;
import com.vergilon.friend_service.services.impl.CityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cities")
@AllArgsConstructor
public class CityController {

    private final CityService cityService;

    @PostMapping
    public CityDto createCityByName(@RequestBody String name) {
        return cityService.createByName(name);
    }
}
