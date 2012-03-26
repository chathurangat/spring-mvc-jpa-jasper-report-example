package org.convey.user.registration.dao.Impl;

import org.convey.user.registration.dao.ModuleDao;
import org.convey.user.registration.model.Module;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by IntelliJ IDEA.
 * User: chathuranga
 * Date: 2/17/12
 * Time: 9:04 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ModuleDaoImpl implements ModuleDao{

    @PersistenceContext
    EntityManager entityManager;


    public Module addNewModule(Module module) {

        Module mergedModule = entityManager.merge(module);
        return mergedModule;

    }//addNewModule



    public Module updateGivenModule(Module module){

        Module mergedModule = entityManager.merge(module);
        entityManager.flush();

        return mergedModule;

    }//updateGivenModule


    public Module getModuleByID(Module module){


        Query query = entityManager.createQuery("from Module where id = :moduleID");
        query.setParameter("moduleID",module.getId());

        Module retrievedModule =(Module)query.getSingleResult();

        return retrievedModule;

    }//getModuleByID


    public void removeGivenModule(Module module) {

//        Query query = entityManager.createQuery("delete from Module where id = :module_id");
//        query.setParameter("module_id",module.getId());
//        query.executeUpdate();

        entityManager.remove(module);
        entityManager.flush();

    }


}//ModuleDaoImpl
