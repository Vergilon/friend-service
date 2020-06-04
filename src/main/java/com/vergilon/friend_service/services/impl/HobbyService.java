package com.vergilon.friend_service.services.impl;

import com.vergilon.friend_service.dto.HobbyDto;

import java.util.UUID;

public interface HobbyService {

    public HobbyDto getById(UUID hobbyId);

    public HobbyDto createByName(String name);
}
