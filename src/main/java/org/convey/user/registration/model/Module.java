package org.convey.user.registration.model;

import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "module")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "module_id")
    private int id;

    @Column(name = "module_name",unique = true)
    private String moduleName;

    @Column(name = "module_description")
    private String moduleDescription;

    @ManyToMany
    @JoinTable(name ="user_module",
            joinColumns = {@JoinColumn(name = "moduleID", referencedColumnName = "module_id")},
            inverseJoinColumns = {@JoinColumn(name = "userID", referencedColumnName ="user_id")})
    private List<User> users;

    @Version
    private int version;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleDescription() {
        return moduleDescription;
    }

    public void setModuleDescription(String moduleDescription) {
        this.moduleDescription = moduleDescription;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }


}//Module
