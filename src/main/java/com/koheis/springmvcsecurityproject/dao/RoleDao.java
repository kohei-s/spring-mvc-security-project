package com.koheis.springmvcsecurityproject.dao;

import com.koheis.springmvcsecurityproject.entity.Role;

public interface RoleDao {

    Role findRoleByName(String theRoleName);
}
