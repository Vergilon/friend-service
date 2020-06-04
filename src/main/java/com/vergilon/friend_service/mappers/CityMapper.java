package com.vergilon.friend_service.mappers;

import com.vergilon.friend_service.dto.CityDto;
import com.vergilon.friend_service.models.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {
    CityDto toDto(City dto);
    City toEntity(CityDto city);
}
