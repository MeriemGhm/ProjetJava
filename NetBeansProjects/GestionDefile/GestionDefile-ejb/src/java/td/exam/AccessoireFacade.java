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
public class AccessoireFacade extends AbstractFacade<Accessoire> implements AccessoireFacadeLocal {
    @PersistenceContext(unitName = "GestionDefile-ejbPU")
    private EntityManager em;

    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccessoireFacade() {
        super(Accessoire.class);
    }

    @Override
    public void creerAccessoire(TypeAccessoire type, double prixAchat, double prixLocation, double prixAssurance, Vetement vetement) {
        Accessoire a = new Accessoire();
        a.setType(type);
        a.setPrixAchat(prixAchat);
        a.setPrixLocation(prixLocation);
        a.setPrixAssurance(prixAssurance);
        a.setVetement(vetement);
        getEntityManager().persist(a);
    }

    
    //Permet d'afficher l'ensemble des accessoires d'un vêtement
    @Override
    public java.util.List<Accessoire> rechercheAccessoire(Vetement vetement) {
        String txt = "SELECT v FROM Vetement AS v WHERE v.vetement =:vet";
        Query req = em.createQuery(txt);
        req.setParameter("vet", vetement);
        List<Accessoire> result = req.getResultList();
        return result;
    }
    
    
    
}
