package com.vergilon.friend_service.controllers;

import com.vergilon.friend_service.dto.UserCreateDto;
import com.vergilon.friend_service.dto.UserDto;
import com.vergilon.friend_service.services.impl.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable UUID userId) {
        return userService.getById(userId);
    }

    @PutMapping("/{userId}/hobbies")
    public void setUserHobbyByUserIdAndHobbyId(@PathVariable UUID userId, @RequestBody String hobbyIds) {
        userService.setHobbies(userId, hobbyIds);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{userId}/city/{newCityId}")
    public void changeUserCity(@PathVariable UUID userId, @PathVariable UUID newCityId) {
        userService.changeCity(userId, newCityId);
    }

    @PostMapping
    public UUID createUser(@RequestBody UserCreateDto dto) {
        return userService.createUser(dto);
    }

    @GetMapping("/cities/{cityId}")
    public List<UserDto> getUsersByCityId(@PathVariable UUID cityId) {
        return userService.findAllUsersByCity(cityId);
    }
}
