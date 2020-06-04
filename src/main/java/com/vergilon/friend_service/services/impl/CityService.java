package com.vergilon.friend_service.services.impl;

import com.vergilon.friend_service.dto.CityDto;
import com.vergilon.friend_service.models.City;

import java.util.List;
import java.util.UUID;

public interface CityService {

    public CityDto getById(UUID cityId);

    public CityDto createByName(String name);


}
