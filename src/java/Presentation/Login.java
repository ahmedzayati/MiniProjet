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

/**
 *
 * @author ahmed
 */
@Named(value = "login")
@RequestScoped
public class Login {
    @EJB
    private UserFacade userFacade;
    private String email;
    private String password;
    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public Login() {
        
    }
    public String connection(){
           User user=this.userFacade.findUserByMail(this.email);
           
           
           
           return ("");
    }
    
}
