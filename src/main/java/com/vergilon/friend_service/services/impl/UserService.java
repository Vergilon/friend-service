package com.vergilon.friend_service.services.impl;

import com.vergilon.friend_service.dto.UserCreateDto;
import com.vergilon.friend_service.dto.UserDto;
import com.vergilon.friend_service.models.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    public UserDto getById(UUID userId);

    public List<UserDto> getAllUsers();

    public void setHobbies(UUID userId, String hobbyIds);

    public UUID createUser(UserCreateDto dto);

    public void changeCity(UUID userId, UUID newCityId);

    public List<UserDto> findAllUsersByCity(UUID cityId);
}
