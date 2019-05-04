/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import JavaBeans.UserFacade;
import entities.User;
import java.util.List;
import java.util.Vector;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ahmed
 */
@ManagedBean(name = "membersView")
@RequestScoped
public class membersView {
FacesContext facesContext = FacesContext.getCurrentInstance();
    /**
     * Creates a new instance of membersView
     */
    @EJB
    private UserFacade userFacade;
    private Vector<User> members = new Vector<User>();
    private User user;
    public membersView() {
    }
    
    /**
     * @return the members
     */
    public Vector<User> getMembers() {
        return members;
    }

    /**
     * @param members the members to set
     */
    public void setMembers(Vector<User> members) {
        this.members = members;
    }
    
    public Vector<User> renderMembers(){
       return this.userFacade.otherUsers(this.user.getIdUser());
        
    }

    @PostConstruct
    public void init() {
        
        this.user=(User)facesContext.getExternalContext().getSessionMap().get("user");
       this.members=renderMembers();
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
}
