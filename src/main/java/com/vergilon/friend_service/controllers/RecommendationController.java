package com.vergilon.friend_service.controllers;

import com.vergilon.friend_service.dto.FriendDto;
import com.vergilon.friend_service.dto.UserDto;
import com.vergilon.friend_service.services.RecommendationHandler;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/recommends")
@AllArgsConstructor
public class RecommendationController {

    private final RecommendationHandler recommendationHandler;

    @GetMapping
    public List<UserDto> findPotentialFriends(@RequestBody FriendDto dto) {
        return recommendationHandler.findFriends(dto.getUserId(), dto.isCity());
    }
}
