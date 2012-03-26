package org.convey.user.registration.dao;

import org.convey.user.registration.model.Module;
import org.convey.user.registration.dao.ModuleDao;

import org.convey.user.registration.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ModuleDaoTest {

    @Autowired
    ModuleDao moduleDao;


    @Test
    public void testAddNewModule(){

        Module module1 = new Module();
        module1.setModuleName("Inventory");
        module1.setModuleDescription("Inventory control system module of the Chathuranga IT Solutions (Pvt) Ltd");

//        User user1 = new User();
//        user1.setId(1);
//
//        List<User> users = new ArrayList<User>();
//        users.add(user1);
//
//        module1.setUsers(users);
        Module persistedModule = moduleDao.addNewModule(module1);

        Assert.assertEquals(module1.getModuleName(),persistedModule.getModuleName());

        Module module2 = new Module();
        module2.setModuleName("Attendance");
        module2.setModuleDescription("Attendance system module of the Chathuranga IT Solutions (Pvt) Ltd");

        Module persistedModule2 = moduleDao.addNewModule(module2);

        Assert.assertEquals(module2.getModuleName(),persistedModule2.getModuleName());

    }//testAddNewModule



    @Test
    public void testGetModuleById(){

        Module module = new Module();
        module.setId(1);

        Module retrievedModule = moduleDao.getModuleByID(module);

        Assert.assertEquals(module.getId(),retrievedModule.getId());

    }//testGetModuleById


    @Test
    public void testUpdateGivenModule(){


        Module module= new Module();
        module.setId(1);

        Module retrievedModule = moduleDao.getModuleByID(module);
        retrievedModule.setModuleName("Inventory-Updated");

        Module updatedModule = moduleDao.updateGivenModule(retrievedModule);

        Assert.assertEquals(updatedModule.getModuleName(),retrievedModule.getModuleName());

    }//testUpdateGivenModule



//    @Test
//    public void testRemoveGivenModule(){
//
//        Module module = new Module();
//        module.setId(1);
//
//        module = moduleDao.getModuleByID(module);
//
//        moduleDao.removeGivenModule(module);
//
//    }//testRemoveGivenModule



}//ModuleDaoTest
