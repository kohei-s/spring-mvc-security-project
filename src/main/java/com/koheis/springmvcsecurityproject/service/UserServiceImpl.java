package com.koheis.springmvcsecurityproject.service;

import com.koheis.springmvcsecurityproject.entity.Role;
import com.koheis.springmvcsecurityproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService{

    private UserDao userDao;
    private RoleDao roleDao;

    @Autowired
    public userServiceImpl(UserDao userDao, RoleDao roleDao){
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
    public User findByUserName (String userName){

        return userDao.findByUserName (userName);
    }

    @Override
    public UserDatils loadUserByUsername (String userName)throws UsernameNotFoundException {
        User user = userDao.findByUserName (userName);
        if (user == null){
            throw new UsernameNotFoundException ("Invalid username or password.");
        }

        return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(), mapRolesToAutorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAutorities(Collection<Role> roles){

        return roles.stream().map(role ->
                new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}
