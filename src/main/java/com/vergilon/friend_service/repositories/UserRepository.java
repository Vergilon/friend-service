package com.vergilon.friend_service.repositories;

import com.vergilon.friend_service.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findById(UUID userId);

    List<User> findByCityId(UUID cityId);

    @Modifying
    @Query(value = "update users set city_id = :cityId where id = :userId", nativeQuery = true)
    void changeCityByUserIdAndCityId(@Param("userId") UUID userId, @Param("cityId") UUID cityId);
}
