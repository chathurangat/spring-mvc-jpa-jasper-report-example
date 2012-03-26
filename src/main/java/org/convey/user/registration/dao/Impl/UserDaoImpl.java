package org.convey.user.registration.dao.Impl;

import org.convey.user.registration.dao.UserDao;
import org.convey.user.registration.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: chathuranga
 * Date: 2/13/12
 * Time: 4:32 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;


    public User registerNewUser(User user) {

        User userMerged = entityManager.merge(user);
        entityManager.flush();
        return userMerged;

    }//registerNewUser




    public User updateUserDetails(User user) {

        User userMerged = entityManager.merge(user);
        entityManager.flush();
        return userMerged;

    }//registerNewUser



    public User getUserDetailsByEmail(User user) {

        Query query = entityManager.createQuery("from User where email = :email");
        query.setParameter("email",user.getEmail());

        User retrievedUser = (User) query.getSingleResult();

        return retrievedUser;

    }//getUserDetails




    public void removeAllRegisteredUsers() {

        Query query=entityManager.createQuery("delete from User");
        query.executeUpdate();

    }//removeAllUsers



    public List<User> retrieveAllRegisteredUsers() {

        Query query=entityManager.createQuery("from User");

        List<User> allUsers = query.getResultList();

        return allUsers;

    }//retrieveAllRegisteredUsers


    public void removeUser(User user) {

        entityManager.remove(user);
        entityManager.flush();

    }


}//UserDaoImpl


