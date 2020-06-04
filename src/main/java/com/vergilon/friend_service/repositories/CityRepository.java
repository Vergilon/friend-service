package com.vergilon.friend_service.repositories;

import com.vergilon.friend_service.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CityRepository extends JpaRepository<City, UUID> {

    Optional<City> findById(UUID cityId);
}
