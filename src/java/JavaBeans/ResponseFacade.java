/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;

import entities.Question;
import entities.Response;
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
public class ResponseFacade extends AbstractFacade<Response> {

    @PersistenceContext(unitName = "MiniProjetPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResponseFacade() {
        super(Response.class);
    }
    public Vector<Response> findQuesResp(Question q){
         Query query=em.createNamedQuery("Response.findByQues", User.class);
                query.setParameter("q",q);
           return  (Vector<Response>) query.getResultList();
        
    }
    
        
    
}
