/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam.Facades;

import td.exam.BeansEntite.Couturier;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import td.exam.AbstractFacade;

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
    public java.util.List<Couturier> rechercheCourturierNom(String nom) {
        String txt = "SELECT c FROM Couturier AS c WHERE c.nom =:n";
        Query req = em.createQuery(txt);
        req.setParameter("n", nom);
        List<Couturier> result = req.getResultList();
        return result;
    }

    @Override
    public java.util.Collection<Couturier> rechercherCouturiers() {
        String txt = "SELECT c FROM Couturier AS c";
        Query req = em.createQuery(txt);
        List<Couturier> result = req.getResultList();
        return result;
    }

    @Override
    public Couturier rechercheCouturierId(long coutId) {
        String txt = "SELECT c FROM Couturier AS c WHERE c.id =:ident";
        Query req = em.createQuery(txt);
        req.setParameter("ident", coutId);
        Couturier result = (Couturier)req.getResultList();
        return result;
    }
    
    
    
    
    
    
}
