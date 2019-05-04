/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import JavaBeans.AmitieFacade;
import JavaBeans.QuestionFacade;
import JavaBeans.UserFacade;
import entities.Amitie;
import entities.Question;
import entities.User;
import java.util.Vector;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ahmed
 */
@ManagedBean( name = "questionView")
@RequestScoped
public class QuestionView {

    /**
     * Creates a new instance of QuestionView
     */
    @EJB
    private QuestionFacade questionFacade;
    @EJB
    private AmitieFacade amitieFacade;
    @EJB
    private UserFacade userFacade;
    private Vector<Question> questions=new Vector<Question>();
    private Question question = new Question() ;
        private Vector<Amitie> amities=new Vector<Amitie>();

    
    public QuestionView() {
    }
    
     public Question getQuestion() {
        return question;
    }

    
    public void setQuestion(Question question) {
        this.question = question;
    }
    
    
    public void postQuestion(){
        System.out.println("scgbshjcbjsgcb");
        System.out.println(this.question);
        FacesContext facesContext = FacesContext.getCurrentInstance();
               
        
        this.question.setIdUser((User)facesContext.getExternalContext().getSessionMap().get("user"));
        this.questionFacade.create(question);
    }
    
    public void userQuestions(){
                FacesContext facesContext = FacesContext.getCurrentInstance();
                 User user=(User)facesContext.getExternalContext().getSessionMap().get("user");
                         Vector<Question> ali =new Vector<Question>();

        Vector<Amitie> tmp =this.amitieFacade.findAmitieById(user);
        for( int i=0;i<tmp.size();i++){
          Vector<Question> x=  questionFacade.findUserQuestion(tmp.get(i).getUser1());
          for(int j=0;j<x.size();j++){
              ali.add(x.get(j));
          }
            System.out.println(tmp.get(i).getUser());
            System.out.println(i);
        }
        System.out.println(tmp.size()+"hhnbb");
        this.questions=ali;
    }
@PostConstruct
    public void init() {
        
        
      this.userQuestions();
    }
    /**
     * @return the questions
     */
    public User findUser(User id){
        return this.userFacade.findUserById(id.getIdUser());
    }
    public Vector<Question> getQuestions() {
        return questions;
    }

    /**
     * @param questions the questions to set
     */
    public void setQuestions(Vector<Question> questions) {
        this.questions = questions;
    }

    /**
     * @return the amities
     */
    public Vector<Amitie> getAmities() {
        return amities;
    }

    /**
     * @param amities the amities to set
     */
    public void setAmities(Vector<Amitie> amities) {
        this.amities = amities;
    }

 
   
}
