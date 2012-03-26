package org.convey.user.registration.dao;

import org.convey.user.registration.model.UserRole;


public interface UserRoleDao{

    public UserRole addNewUserRole(UserRole userRole);

    public void removeAllUserRoles();

}//UserRoleDao
