package com.vergilon.friend_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class FriendDto {

    private UUID userId;
    private String name;
}
