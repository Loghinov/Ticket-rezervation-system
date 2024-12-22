package org.example.service.Impl;

import org.example.dao.UserDao;
import org.example.dto.UserDto;
import org.example.entity.Roles;
import org.example.entity.User;
import org.example.service.RolesService;
import org.example.service.UserService;
import org.springframework.stereotype.Service;

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
        Roles roles = rolesService.getRoleById(user.getRoleId());
        UserDto userDto = new UserDto(user.getUserId(),user.getFirstName(),user.getLastName(), user.getAge(),roles);
        return userDto;
    }
}
