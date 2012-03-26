package org.convey.user.registration.dao;

import org.convey.user.registration.model.User;

import java.util.List;

public interface UserDao {


    public User registerNewUser(User user);

    public User getUserDetailsByEmail(User user);

    public void removeAllRegisteredUsers();

    public List<User> retrieveAllRegisteredUsers();

    public void removeUser(User user);

    public User updateUserDetails(User user);


}//UserDao
