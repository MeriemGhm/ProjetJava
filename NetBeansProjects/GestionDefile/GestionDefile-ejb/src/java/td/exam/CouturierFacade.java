/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Meriem
 */
@Stateless
public class CouturierFacade extends AbstractFacade<Couturier> implements CouturierFacadeLocal {
    @PersistenceContext(unitName = "GestionDefile-ejbPU")
    private EntityManager em;

    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CouturierFacade() {
        super(Couturier.class);
    }

    @Override
    public void creerCouturier(String nom, String prenom, String adresse, String telephone, String login, String password) {
        Couturier c = new Couturier();
        c.setNom(nom);
        c.setPrenom(prenom);
        c.setAdresse(adresse);
        c.setTelephone(telephone);
        c.setLogin(login);
        c.setPassword(password);
        getEntityManager().persist(c);
    }

    
    //Permet de rechercher un couturier à partir de son nom
    @Override
    public java.util.List<Couturier> rechercheCourturier(String nom) {
        String txt = "SELECT c FROM Couturier AS c WHERE c.nom =:n";
        Query req = em.createQuery(txt);
        req.setParameter("n", nom);
        List<Couturier> result = req.getResultList();
        return result;
    }
    
    
    
    
}
