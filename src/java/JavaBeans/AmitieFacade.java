/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;

import entities.Amitie;
import entities.User;
import java.util.Vector;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author ahmed
 */
@Stateless
public class AmitieFacade extends AbstractFacade<Amitie> {

    @PersistenceContext(unitName = "MiniProjetPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AmitieFacade() {
        super(Amitie.class);
    }
    public Amitie findAmitie(User idUser,User useIdUser){
         Query query=em.createNamedQuery("Amitie.findAmitie", Amitie.class);
                query.setParameter("useIdUser",idUser);
                  query.setParameter("idUser",useIdUser);
                      return (Amitie) query.getSingleResult();
                                
    }
    public Vector<Amitie> findAmitieById(User id ){
                 Query query=em.createNamedQuery("Amitie.findByIdUser", Amitie.class);
                  query.setParameter("idUser",id);
                  return( Vector<Amitie>) query.getResultList();


    }
    
    
}
