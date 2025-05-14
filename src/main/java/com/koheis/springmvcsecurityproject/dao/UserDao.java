package com.koheis.springmvcsecurityproject.dao;

import com.koheis.springmvcsecurityproject.entity.User;

public interface UserDao {

    User findByUserName (String userName);
}
