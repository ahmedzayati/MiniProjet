/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;

import entities.Question;
import entities.User;
import java.util.Vector;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ahmed
 */
@Stateless
public class QuestionFacade extends AbstractFacade<Question> {

    @PersistenceContext(unitName = "MiniProjetPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QuestionFacade() {
        super(Question.class);
    }
    
    public Vector<Question> findUserQuestion(User id){
         Query query=em.createNamedQuery("Question.findUserQuestion", User.class);
                query.setParameter("id",id);
           return  (Vector<Question>) query.getResultList();
        
    }
}
