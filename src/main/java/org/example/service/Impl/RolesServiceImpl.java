package org.example.service.Impl;

import org.example.dao.RolesDao;
import org.example.entity.Role;
import org.example.service.RolesService;
import org.springframework.stereotype.Service;

@Service
public class RolesServiceImpl implements RolesService {
    private RolesDao rolesDao;

    public RolesServiceImpl(RolesDao rolesDao) {
        this.rolesDao = rolesDao;
    }

    @Override
    public Role getRoleById(long roleId) {
        Role role = rolesDao.getById(roleId);
        return role;
    }
}
