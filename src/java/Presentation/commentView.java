/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import JavaBeans.ResponseFacade;
import JavaBeans.UserFacade;
import entities.Question;
import entities.Response;
import entities.User;
import java.util.Vector;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author ahmed
 */
@ManagedBean(name = "commentView")
@RequestScoped
public class commentView {

    /**
     * @return the responses
     */
    public Vector<Response> getResponses() {
        return responses;
    }

    /**
     * @param responses the responses to set
     */
    public void setResponses(Vector<Response> responses) {
        this.responses = responses;
    }

    /**
     * Creates a new instance of commentView
     */
    @EJB
    private ResponseFacade reponseFacade;
    private Response response=new Response();
    @EJB
    private UserFacade userFacade;
    private Vector<Response> responses=new Vector<Response>();
    public commentView() {
    }
    
    public void postResponse(Question idQues){
        System.out.println("scgbshjcbjsgcb");
        System.out.println(this.getResponse());
        FacesContext facesContext = FacesContext.getCurrentInstance();
               
        this.getResponse().setIdQues(idQues);
        this.getResponse().setIdUser((User)facesContext.getExternalContext().getSessionMap().get("user"));
        this.reponseFacade.create(getResponse());
    }

    /**
     * @return the response
     */
    public Response getResponse() {
        return response;
    }

    /**
     * @param response the response to set
     */
    public Vector<Response> getResponses(Question q){
        return (Vector<Response>)this.reponseFacade.findQuesResp(q);
    }
    public void setResponse(Response response) {
        this.response = response;
    }
    public User findUser(User id){
        return this.userFacade.findUserById(id.getIdUser());
}
}
