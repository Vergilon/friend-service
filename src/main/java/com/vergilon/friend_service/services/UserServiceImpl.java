package com.vergilon.friend_service.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vergilon.friend_service.dto.UserCreateDto;
import com.vergilon.friend_service.dto.UserDto;
import com.vergilon.friend_service.mappers.CityMapper;
import com.vergilon.friend_service.mappers.HobbyMapper;
import com.vergilon.friend_service.mappers.UserMapper;
import com.vergilon.friend_service.models.City;
import com.vergilon.friend_service.models.Hobby;
import com.vergilon.friend_service.models.User;
import com.vergilon.friend_service.repositories.UserRepository;
import com.vergilon.friend_service.services.impl.CityService;
import com.vergilon.friend_service.services.impl.HobbyService;
import com.vergilon.friend_service.services.impl.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final HobbyService hobbyService;
    private final CityService cityService;
    private final UserMapper userMapper;
    private final HobbyMapper hobbyMapper;
    private final CityMapper cityMapper;

    @Override
    public UserDto getById(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(NullPointerException::new);
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userMapper.toDtos(userRepository.findAll());
    }

    @Override
    public void setHobbies(UUID userId, String hobbyIds) {
        User user = userRepository.findById(userId).orElseThrow(NullPointerException::new);
        List<Hobby> hobbies = new ArrayList<>();
        List<UUID> listOfHobbyId = new ArrayList<>();
        try {
            listOfHobbyId = new ObjectMapper().readValue(hobbyIds, new TypeReference<List<UUID>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (UUID hobbyId : listOfHobbyId) {
            hobbies.add(hobbyMapper.toEntity(hobbyService.getById(hobbyId)));
        }
        user.addHobbies(hobbies);
        userRepository.save(user);
    }

    @Override
    public UUID createUser(UserCreateDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        City city = cityMapper.toEntity(cityService.getById(dto.getCityId()));
        user.setCity(city);
        userRepository.save(user);
        log.info(user.getId().toString());
        return user.getId();
    }

    @Override
    @Transactional
    public void changeCity(UUID userId, UUID newCityId) {
        userRepository.changeCityByUserIdAndCityId(userId, newCityId);
    }

    @Override
    public List<UserDto> findAllUsersByCity(UUID cityId) {
        return userMapper.toDtos(userRepository.findByCityId(cityId));
    }
}
