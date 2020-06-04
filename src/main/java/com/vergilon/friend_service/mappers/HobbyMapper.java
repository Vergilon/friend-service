package com.vergilon.friend_service.mappers;

import com.vergilon.friend_service.dto.HobbyDto;
import com.vergilon.friend_service.models.Hobby;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HobbyMapper {

    HobbyDto toDto(Hobby hobby);
    Hobby toEntity(HobbyDto dto);
}
