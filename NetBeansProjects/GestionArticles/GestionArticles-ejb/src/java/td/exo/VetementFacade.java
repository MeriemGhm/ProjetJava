/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exo;

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
public class VetementFacade extends AbstractFacade<Vetement> implements VetementFacadeLocal {
    @PersistenceContext(unitName = "GestionArticles-ejbPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VetementFacade() {
        super(Vetement.class);
    }

    @Override
    public void creerVetement(String designation, double prix, String type, Fournisseur fournisseur, String colori) {
        Vetement v = new Vetement();
        v.setDesignation(designation);
        v.setPrix(prix);
        v.setType(type);
        v.setLeFournisseur(fournisseur);
        v.setColori(colori);
        getEntityManager().persist(v);
    }

    @Override
    public java.util.List<Vetement> rechercherVetement(Fournisseur fournisseur) {
        String txt = "SELECT v FROM Vetement AS v WHERE v.leFournisseur =:f";
        Query req = em.createQuery(txt);
        req.setParameter("f", fournisseur);
        List<Vetement> result = req.getResultList();
        return result;
    }
    
    
    
}
