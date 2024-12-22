package org.example.service.Impl;

import org.example.dao.RolesDao;
import org.example.entity.Roles;
import org.example.service.RolesService;
import org.springframework.stereotype.Service;

@Service
public class RolesServiceImpl implements RolesService {
    private RolesDao rolesDao;

    public RolesServiceImpl(RolesDao rolesDao) {
        this.rolesDao = rolesDao;
    }

    @Override
    public Roles getRoleById(long roleId) {
        Roles roles = rolesDao.getById(roleId);
        return roles;
    }
}
