package org.convey.user.registration.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "username" , nullable = false , unique = true)
    private String userName;

    @Column(name = "password" , nullable = false)
    private String passWord;

    @Column(name = "email" , nullable = false , unique = true)
    private String email;

    @Column(name = "confirmation_code",length = 20)
    private String confirmationCode;

    @Column(name = "first_name" , length = 50,nullable = false)
    private String firstName;

    @Column(name = "last_name" , length = 50)
    private String lastName;

    @Column(name = "register_date")
    private Date registeredDate;

    @Column(name = "activate_status")
    private boolean  activate;

    @Version
    private int version;

    @ManyToMany
    @JoinTable(name ="user_module",
            joinColumns = {@JoinColumn(name = "userID", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "moduleID", referencedColumnName ="module_id")})
    private List<Module> modules;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }


    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}//User
