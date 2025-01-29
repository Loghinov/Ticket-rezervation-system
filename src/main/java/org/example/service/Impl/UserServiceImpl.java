package org.example.service.Impl;

import org.example.dao.UserDao;
import org.example.dto.UserDto;
import org.example.entity.Role;
import org.example.entity.User;
import org.example.service.RolesService;
import org.example.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private RolesService rolesService;

    public UserServiceImpl (UserDao userDao, RolesService rolesService) {
        this.userDao=userDao;
        this.rolesService = rolesService;

    }

    @Override
    public UserDto getUserById(long userId) {
        User user = userDao.getById(userId);
        Role role = rolesService.getRoleById(user.getRoleId());
        UserDto userDto = new UserDto(user.getUserId(), user.getFirstName(), user.getLastName(), user.getAge(), role);
        return userDto;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        User user = new User();
        user.setRoleId(userDto.getRoles().getRoleId());
        user.setAge(userDto.getAge());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user = userDao.save(user);
        userDto.setUserId(user.getUserId());
        return userDto;
    }

    @Override
    public UserDto update(long userId, UserDto userDto) {
        return null;
    }

    @Override
    public UserDto save(UserDto userDto) {
        return null;
    }

    @Override
    public void delete(long userId) {

    }

    @Override
    public List<User> getAll() {
        return List.of();
    }
}
