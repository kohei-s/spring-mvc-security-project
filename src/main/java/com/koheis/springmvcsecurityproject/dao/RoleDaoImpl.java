package com.koheis.springmvcsecurityproject.dao;

import com.koheis.springmvcsecurityproject.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao{

    private final EntityManager entityManager;

    public RoleDaoImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public Role findRoleByName(String theRoleName) {

        // retrieve/read from database using name
        TypedQuery<Role> theQuery = entityManager.createQuery("from Role where name=:roleName", Role.class);
        theQuery.setParameter("roleName", theRoleName);

        Role theRole;

        try {
            theRole = theQuery.getSingleResult();
        } catch (Exception e) {
            theRole = null;
        }

        return theRole;
    }

}
