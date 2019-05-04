/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;

import entities.User;
import java.util.List;
import java.util.Vector;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ahmed
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {

    @PersistenceContext(unitName = "MiniProjetPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    public User findUserByMail(String email){
       
        Query query=em.createNamedQuery("User.findByMail", User.class);
                query.setParameter("mail",email);
        return  (User) query.getSingleResult();
        
       

    
}
    public User findUserById(Integer id){
       
        Query query=em.createNamedQuery("User.findByIdUser", User.class);
                query.setParameter("idUser",id);
        return  (User) query.getSingleResult();
        
       

    
}
    public Vector<User> otherUsers(Integer idUser){
        
        Query query=em.createNamedQuery("User.otherUsers", User.class);
                query.setParameter("idUser",idUser);
                Vector<User>result=(Vector<User>) query.getResultList();
        return result;
        
        
    

    }

    public Vector<User> otherUsers(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public void edit1(Integer id){
        try{
        Query query=em.createNamedQuery("User.edit1", User.class);
                        query.setParameter("idUser",id);
                        query.executeUpdate();


        }
        catch(Exception e){
        }
    }
    public Vector<User> findUserValid(){
        try{
        Query query=em.createNamedQuery("User.findByValid", User.class);
        return  (Vector<User>) query.getResultList();

        }
        catch(Exception e){
            return null;
        }
    }
    public Vector<User> findUserByIdUser1(){
        try{
        Query query=em.createNamedQuery("User.findByIdUser1", User.class);
            return  (Vector<User>) query.getResultList();

        }
        catch(Exception e){
            return null;
        }
    }
    }

