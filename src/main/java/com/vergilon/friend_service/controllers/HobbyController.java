package com.vergilon.friend_service.controllers;

import com.vergilon.friend_service.dto.HobbyDto;
import com.vergilon.friend_service.services.impl.HobbyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hobbies")
@AllArgsConstructor
public class HobbyController {

    private final HobbyService hobbyService;

    @PostMapping
    public HobbyDto createHobbyByName(@RequestBody String name) {
        return hobbyService.createByName(name);
    }
}
