/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
