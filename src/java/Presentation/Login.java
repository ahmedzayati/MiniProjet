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
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

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
        private User user=new User();

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public Login() {
        
    }
   /* public String connection(){
           User user=this.userFacade.findUserByMail(this.getEmail());
           if(this.password.equals(user.getPassword())){
               FacesContext facesContext = FacesContext.getCurrentInstance();
               facesContext.getExternalContext().getSessionMap().put("user", user);


           
            return("profil");
           }
           
           
           return ("#");
    }*/
public String connection() {

       User user=this.userFacade.findUserByMail(this.getEmail());
        if (this.getEmail().equals("bilel@gmail.com") && this.getPassword().equals("123")){
             FacesContext facesContext = FacesContext.getCurrentInstance();
               facesContext.getExternalContext().getSessionMap().put("user", user);
            return "admin.xhtml" ;
        }
           if(this.password.equals(user.getPassword())){
               FacesContext facesContext = FacesContext.getCurrentInstance();
               facesContext.getExternalContext().getSessionMap().put("user", user);


           
            return("profil");
           }
           
        
       
        
        else return "#";

    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
 
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
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }
}
