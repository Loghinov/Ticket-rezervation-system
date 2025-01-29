package org.example.dao;

import org.example.entity.User;
import org.springframework.stereotype.Repository;

@Repository

public interface UserDao extends Dao<User>{
    User getByRoleId (long roleId);
}
