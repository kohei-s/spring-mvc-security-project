package com.koheis.springmvcsecurityproject.dao;

import com.koheis.springmvcsecurityproject.entity.Role;

public interface RoleDao {

    public Role findRoleByName(String theRoleName);
}
