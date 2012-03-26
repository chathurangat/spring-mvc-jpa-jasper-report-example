package org.convey.user.registration.dao.Impl;

import org.convey.user.registration.dao.UserRoleDao;
import org.convey.user.registration.model.User;
import org.convey.user.registration.model.UserRole;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by IntelliJ IDEA.
 * User: chathuranga
 * Date: 2/14/12
 * Time: 2:58 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserRoleDaoImpl implements UserRoleDao{

    @PersistenceContext
    EntityManager entityManager;


    public UserRole addNewUserRole(UserRole userRole) {

        entityManager.persist(userRole);

        return userRole;

    }//addNewUserRole




    public void removeAllUserRoles() {

        Query query = entityManager.createQuery("delete from UserRole");

        query.executeUpdate();

    }//removeAllUserRoles




}//UserRoleDaoImpl
