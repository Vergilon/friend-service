package com.vergilon.friend_service.dto;

import com.vergilon.friend_service.models.City;
import com.vergilon.friend_service.models.Hobby;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDto {

    private UUID id;
    private String name;
    private int age;
    private City city;
    private List<Hobby> hobbies;
}
