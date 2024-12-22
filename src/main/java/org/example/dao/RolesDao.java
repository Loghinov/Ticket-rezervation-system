package org.example.dao;

import org.example.entity.Roles;

public interface RolesDao extends Dao<Roles> {
    Roles getByRoleName (String roleName);
}
