package org.convey.user.registration.dao;

import org.convey.user.registration.model.Module;

public interface ModuleDao {


    public Module addNewModule(Module module);

    public Module updateGivenModule(Module module);

    public Module getModuleByID(Module module);

    public void removeGivenModule(Module module);

}//ModuleDao
