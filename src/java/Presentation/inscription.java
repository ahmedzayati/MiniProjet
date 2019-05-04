/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import JavaBeans.UserFacade;
import entities.User;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author MAJD-PC
 */
@ManagedBean(name = "inscription")
@RequestScoped
public class inscription {

    /**
     * Creates a new instance of inscription
     */
    @EJB
    private UserFacade userFacade;
    private User user=new User();


    public inscription() {
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the nom
     */
    
    public void submit(){
        this.userFacade.create(user);
    }
}