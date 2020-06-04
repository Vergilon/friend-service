package com.vergilon.friend_service.services;

import com.vergilon.friend_service.dto.CityDto;
import com.vergilon.friend_service.mappers.CityMapper;
import com.vergilon.friend_service.models.City;
import com.vergilon.friend_service.repositories.CityRepository;
import com.vergilon.friend_service.services.impl.CityService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public CityDto getById(UUID cityId) {
        return cityMapper.toDto(cityRepository.findById(cityId)
                .orElseThrow(NullPointerException::new));
    }

    @Transactional
    @Override
    public CityDto createByName(String name) {
        City city = new City();
        city.setName(name);
        cityRepository.saveAndFlush(city);
        log.info("!!!!!!!!!!" + city.getId().toString());
        return cityMapper.toDto(city);
    }
}
