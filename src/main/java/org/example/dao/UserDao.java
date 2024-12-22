package org.example.dao;

import org.example.entity.User;

public interface UserDao extends Dao<User>{
    User getByRoleId (long roleId);
}
