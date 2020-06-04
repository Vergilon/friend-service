package com.vergilon.friend_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserCreateDto {

    private String name;
    private int age;
    private UUID cityId;
}
