package org.convey.user.registration.dao;

import org.convey.user.registration.model.User;
import org.convey.user.registration.model.Module;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Autowired
    ModuleDao moduleDao;

//    @Before
//    public void setUp(){
//
//        userDao.removeAllRegisteredUsers();
//
//    }

    @Test
    public void registerNewUserTest(){

        User testUser1 = new User();

        testUser1.setUserName("chathuranga");
        testUser1.setEmail("chathuranga.t@gmail.com");
        testUser1.setPassWord("123");
        testUser1.setFirstName("dchathuranga");
        testUser1.setRegisteredDate(new Date());

        List<Module> userModules = new ArrayList<Module>();
        Module module1= new Module();
        module1.setId(1);

        module1 = moduleDao.getModuleByID(module1);

        Module module2= new Module();
        module2.setId(2);

        module2 = moduleDao.getModuleByID(module2);


        userModules.add(module1);
        userModules.add(module2);

        testUser1.setModules(userModules);

        User userPersisted1 =  userDao.registerNewUser(testUser1);
        User userRetrieved1 = userDao.getUserDetailsByEmail(testUser1);

        Assert.assertEquals(userRetrieved1,userPersisted1);


        User testUser2 = new User();

        testUser2.setUserName("darshana");
        testUser2.setEmail("chathurangat@lankacom.net");
        testUser2.setPassWord("123");
        testUser2.setFirstName("darshana");

        testUser2.setModules(userModules);

        User userPersisted2 =  userDao.registerNewUser(testUser2);
        User userRetrieved2 = userDao.getUserDetailsByEmail(testUser2);

        Assert.assertEquals(userRetrieved2,userPersisted2);


    }//registerNewUserTest




    @Test
    public void testGetUserDetailsByEmail(){

        User testUser = new User();

        testUser.setEmail("chathuranga.t@gmail.com");

        User userFound = userDao.getUserDetailsByEmail(testUser);

        Assert.assertNotNull(userFound.getId());


    }//testRetrieveUserDetails


    @Test
    public void testUpdateUserDetails(){

        User testUser = new User();

        testUser.setEmail("chathuranga.t@gmail.com");

        testUser = userDao.getUserDetailsByEmail(testUser);
        testUser.setEmail("chathuranga.t@gmail.com");

        userDao.updateUserDetails(testUser);

    }//testUpdateUserDetails


    /*
       @Test
       public void testRemoveUser(){

           User testUser = new User();
           testUser.setEmail("chathuranga.t@gmail.com");

           testUser = userDao.getUserDetailsByEmail(testUser);

           userDao.removeUser(testUser);
       }
    */

//    @Test
//    public void testRemoveAllRegisteredUsers(){
//
//        userDao.removeAllRegisteredUsers();
//    }



}//class