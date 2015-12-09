/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam.Facades;

import java.util.Collection;
import java.util.List;
import td.exam.BeansEntite.Lieu;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import td.exam.AbstractFacade;
import td.exam.BeansEntite.Accessoire;

/**
 *
 * @author Meriem
 */
@Stateless
public class LieuFacade extends AbstractFacade<Lieu> implements LieuFacadeLocal {
    @PersistenceContext(unitName = "GestionDefile-ejbPU")
    private EntityManager em;

    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LieuFacade() {
        super(Lieu.class);
    }

    @Override
    public void creerLieu(String nom, String adresse) {
        Lieu l = new Lieu();
        l.setNom(nom);
        l.setAdresse(adresse);
        getEntityManager().persist(l);
    }
    
    //Eechercher un lieu en fonction du nom
    //Rechercher la disponibilité d'un lieu en passant une date en paramètre 

    @Override
    public Collection<Lieu> rechercherLieux() {
        String txt = "SELECT l FROM Lieu AS l";
        Query req = em.createQuery(txt);
        Collection<Lieu> result = req.getResultList();
        return result;
    }

    @Override
    public Lieu rechercheLieuId(long lieuId) {
        String txt = "SELECT l FROM Lieu AS l WHERE l.id =:lieu";
        Query req = em.createQuery(txt);
        req.setParameter("lieu", lieuId);
        Lieu result = (Lieu)req.getSingleResult();
        return result;
    }
    
    
    
}
