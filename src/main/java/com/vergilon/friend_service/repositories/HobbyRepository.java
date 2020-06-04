package com.vergilon.friend_service.repositories;

import com.vergilon.friend_service.models.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface HobbyRepository extends JpaRepository<Hobby, UUID> {

    Optional<Hobby> findById(UUID hobbyId);
}
