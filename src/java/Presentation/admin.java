/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import JavaBeans.UserFacade;
import entities.User;
import java.util.Iterator;
import java.util.Vector;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author MAJD-PC
 */
@ManagedBean(name = "admin")
@RequestScoped
public class admin {

    /**
     * Creates a new instance of admin
     */
    @EJB
    private UserFacade userFacade;
    private User user = new User();
    private Vector<User> notChecked;
    private Vector<User> notValidated;
    private int id1;

    public admin() {
    }

    public Vector<User> notValid() {
        Vector<User> listUser = new Vector<User>();
        listUser = this.userFacade.findUserValid();
        Iterator<User> itr = listUser.iterator();
        this.notValidated = listUser;
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        return listUser;
    }

    public void checkuser() {
        Vector<User> listUser1 = new Vector<User>();
        listUser1 = this.userFacade.findUserByIdUser1();
        this.notChecked = listUser1;
    }

    public void valide(Integer id) {
        this.userFacade.edit1(id);
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
     * @return the noChecked
     */
    public Vector<User> getNotChecked() {
        return notChecked;
    }

    /**
     * @param noChecked the noChecked to set
     */
    public void setNotChecked(Vector<User> noChecked) {
        this.notChecked = noChecked;
    }

    /**
     * @return the notValidated
     */
    public Vector<User> getNotValidated() {
        return notValidated;
    }

    /**
     * @param notValidated the notValidated to set
     */
    public void setNotValidated(Vector<User> notValidated) {
        this.notValidated = notValidated;
    }

    /**
     * @return the id1
     */
    public int getId1() {
        return id1;
    }

    /**
     * @param id1 the id1 to set
     */
    public void setId1(int id1) {
        this.id1 = id1;
    }

}