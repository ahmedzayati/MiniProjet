/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import JavaBeans.AmitieFacade;
import entities.Amitie;
import entities.AmitiePK;
import entities.User;
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
@ManagedBean(name = "followView")
@RequestScoped
public class followView {

    @EJB
    private AmitieFacade amitieFacade;
    private AmitiePK amitie = new AmitiePK();
    private Amitie am = new Amitie() ;
        private AmitiePK amitie2 = new AmitiePK();

    private Amitie am2 = new Amitie() ;

    private User user ;
    private boolean var;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public followView() {
    }
    public void follow(User user){
        
        FacesContext facesContext = FacesContext.getCurrentInstance();       
        User tmp=(User)facesContext.getExternalContext().getSessionMap().get("user");
        this.amitie.setIdUser((int)tmp.getIdUser());
        this.amitie.setUseIdUser((int)user.getIdUser());
        this.am.setAmitiePK(amitie);
        this.am.setUser(tmp);
        this.am.setUser1(user);
        
        this.amitieFacade.create(am);
    }
    public void unfollow(User user){
        
        FacesContext facesContext = FacesContext.getCurrentInstance();       
        User tmp=(User)facesContext.getExternalContext().getSessionMap().get("user");
        this.amitie.setIdUser((int)tmp.getIdUser());
        this.amitie.setUseIdUser((int)user.getIdUser());
        this.am.setAmitiePK(amitie);
        this.am.setUser(tmp);
        this.am.setUser1(user);
        
        this.amitieFacade.remove(am);
    }

    /**
     * @return the amitie
     */
    public boolean checkAmitie(User userr){
                FacesContext facesContext = FacesContext.getCurrentInstance();       

                User tmp=(User)facesContext.getExternalContext().getSessionMap().get("user");
                this.amitie2.setIdUser(tmp.getIdUser());
        this.amitie2.setUseIdUser(userr.getIdUser());
        this.am2.setAmitiePK(amitie2);
        this.am2.setUser(tmp);
        this.am2.setUser1(userr);
try{
        if(amitieFacade.findAmitie(am2.getUser(), am2.getUser1())!=null){
            return(true);
        }
        else return false;
}catch(Exception e){return false;}
    }
    public AmitiePK getAmitie() {
        return amitie;
    }

    /**
     * @param amitie the amitie to set
     */
    public void setAmitie(AmitiePK amitie) {
        this.amitie = amitie;
    }

    /**
     * @return the var
     */
    public boolean isVar() {
        return var;
    }

    /**
     * @param var the var to set
     */
    public void setVar(boolean var) {
        this.var = var;
    }
}
