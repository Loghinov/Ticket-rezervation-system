package org.example.dao;

import org.example.entity.Role;

public interface RolesDao extends Dao<Role> {
    Role getByRoleName (String roleName);
}
