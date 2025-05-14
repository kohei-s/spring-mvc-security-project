package com.koheis.springmvcsecurityproject.dao;

import com.koheis.springmvcsecurityproject.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    private final EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public User findByUserName (String theUserName) {

        TypedQuery<User> theQuery = entityManager.createQuery(
                "from User where userName=:uName and enabled=true", User.class
        );

        theQuery.setParameter("uName", theUserName);

        User theUser;
        try {
            theUser = theQuery.getSingleResult();
        } catch (Exception e) {
            theUser = null;
        }

        return theUser;
    }

}
