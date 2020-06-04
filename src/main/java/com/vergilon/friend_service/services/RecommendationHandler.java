package com.vergilon.friend_service.services;

import com.vergilon.friend_service.dto.FriendDto;
import com.vergilon.friend_service.dto.UserDto;
import com.vergilon.friend_service.mappers.UserMapper;
import com.vergilon.friend_service.models.Hobby;
import com.vergilon.friend_service.models.User;
import com.vergilon.friend_service.services.impl.UserService;
import com.vergilon.friend_service.util.MapUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@AllArgsConstructor
public class RecommendationHandler {

    private final UserService userService;
    private final UserMapper userMapper;

    public List<UserDto> findFriends(FriendDto dto) {
        return userMapper.toDtos(findFriendForUser(dto.getUserId()));
    }

    public List<User> findFriendForUser(UUID userId) {
        UserDto userDto = userService.getById(userId);
        List<UserDto> allUsersByCity = userService.findAllUsersByCity(userDto.getCity().getId());
        return filterByHobby(userMapper.toEntity(userDto), userMapper.toEntities(allUsersByCity));
    }

    public List<User> filterByHobby(User user, List<User> potentialFriends) {
        List<Hobby> userHobbies = user.getHobbies();
        Map<User, Integer> potentialMap = new HashMap<>();
        for (User potentialFriend : potentialFriends) {
            userHobbies.retainAll(potentialFriend.getHobbies());
            if(userHobbies.size() > 0) {
                potentialMap.put(potentialFriend, userHobbies.size());
            }
        }
        Map<User, Integer> sortedPotentialMap = MapUtil.sortByValue(potentialMap);
        return new ArrayList<>(sortedPotentialMap.keySet());
    }
}
