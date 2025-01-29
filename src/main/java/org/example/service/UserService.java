package org.example.service;

import org.example.dto.UserDto;
import org.example.entity.User;

import java.util.List;

public interface UserService {
    UserDto getUserById(long userId);
    UserDto addUser(UserDto userDto);
    UserDto update(long userId, UserDto userDto);
    UserDto save(UserDto userDto);
    void delete(long userId);
    List<User>getAll();


}
