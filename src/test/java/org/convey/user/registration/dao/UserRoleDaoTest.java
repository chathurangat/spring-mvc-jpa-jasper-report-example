package org.convey.user.registration.dao;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import org.convey.user.registration.model.UserRole;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;



/**
 * Created by IntelliJ IDEA.
 * User: chathuranga
 * Date: 2/14/12
 * Time: 3:55 PM
 * To change this template use File | Settings | File Templates.
 */

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserRoleDaoTest {


    @Autowired
    UserRoleDao userRoleDao;


//    @Before
//    public void setUp() {
//
//        userRoleDao.removeAllUserRoles();
//
//    }



    @Test
    public void testAddNewUserRole(){

        UserRole testUserRole1 = new UserRole();

        testUserRole1.setRoleName("ROLE_ADMIN");
        testUserRole1.setRoleDescription("Administrator Role");
        testUserRole1.setDateCreated(new Date());

        UserRole testUserRole1Persisted = userRoleDao.addNewUserRole(testUserRole1);

        Assert.assertEquals(testUserRole1,testUserRole1Persisted);


        UserRole testUserRole2 = new UserRole();

        testUserRole2.setRoleName("ROLE_CONSUMER");
        testUserRole2.setRoleDescription("Consumer User Role");
        testUserRole2.setDateCreated(new Date());

        UserRole testUserRole2Persisted = userRoleDao.addNewUserRole(testUserRole2);

        Assert.assertEquals(testUserRole2,testUserRole2Persisted);


    }// testAddNewUserRole



}//UserRoleDaoTest
