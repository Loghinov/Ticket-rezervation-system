package org.example.service;

import org.example.dto.UserDto;

public interface UserService {
    UserDto getUserById(long userId);
    UserDto addUser(UserDto userDto);
}
