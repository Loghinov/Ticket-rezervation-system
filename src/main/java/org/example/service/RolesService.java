package org.example.service;

import org.example.dao.RolesDao;
import org.example.entity.Roles;

public interface RolesService {
    Roles getRoleById(long roleId);
}
