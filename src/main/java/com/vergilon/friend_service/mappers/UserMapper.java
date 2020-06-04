package com.vergilon.friend_service.mappers;

import com.vergilon.friend_service.dto.UserDto;
import com.vergilon.friend_service.models.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDto dto);
    UserDto toDto(User user);

    List<UserDto> toDtos(List<User> users);
    List<User> toEntities(List<UserDto> users);
}
