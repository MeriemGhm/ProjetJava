/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam.Facades;

import td.exam.BeansEntite.Personne;
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
public class PersonneFacade extends AbstractFacade<Personne> implements PersonneFacadeLocal {
    @PersistenceContext(unitName = "GestionDefile-ejbPU")
    private EntityManager em;

    
    
    
    //Rechercher toutes les personnes affectées à un défilé (organisateur + couturier + mannequins)
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonneFacade() {
        super(Personne.class);
    }

    @Override
    public Personne recherchePersonne(String login) {
        String txt = "SELECT p FROM Personne AS p WHERE p.login =:log";
        Query req = em.createQuery(txt);
        req.setParameter("log", login);
        Personne result = (Personne)req.getSingleResult();
        return result;
    }
    
}
