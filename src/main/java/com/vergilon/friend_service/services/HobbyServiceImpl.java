package com.vergilon.friend_service.services;

import com.vergilon.friend_service.dto.HobbyDto;
import com.vergilon.friend_service.mappers.HobbyMapper;
import com.vergilon.friend_service.models.Hobby;
import com.vergilon.friend_service.repositories.HobbyRepository;
import com.vergilon.friend_service.services.impl.HobbyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class HobbyServiceImpl implements HobbyService {

    private final HobbyRepository hobbyRepository;
    private final HobbyMapper hobbyMapper;

    @Override
    public HobbyDto getById(UUID hobbyId) {
        return hobbyMapper.toDto(hobbyRepository
                .findById(hobbyId)
                .orElseThrow(NullPointerException::new)
        );
    }

    @Override
    public HobbyDto createByName(String name) {
        Hobby hobby = new Hobby();
        hobby.setName(name);
        hobbyRepository.saveAndFlush(hobby);
        return hobbyMapper.toDto(hobby);
    }
}
