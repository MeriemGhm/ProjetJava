/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exo;

import java.util.Date;
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
public class FraicheurFacade extends AbstractFacade<Fraicheur> implements FraicheurFacadeLocal {
    @PersistenceContext(unitName = "GestionArticles-ejbPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FraicheurFacade() {
        super(Fraicheur.class);
    }

    @Override
    public void creerFraicheur(String designation, double prix, String type, Fournisseur fournisseur, Date date_limite) {
        Fraicheur f = new Fraicheur();
        f.setDesignation(designation);
        f.setPrix(prix);
        f.setType(type);
        f.setLeFournisseur(fournisseur);
        f.setDate_limite(date_limite);
        getEntityManager().persist(f);
    }

    @Override
    public java.util.List<Fraicheur> rechercherFraicheur(Fournisseur fournisseur) {
        String txt = "SELECT f FROM Fraichuer AS f WHERE f.leFournisseur =:four";
        Query req = em.createQuery(txt);
        req.setParameter("four", fournisseur);
        List<Fraicheur> result = req.getResultList();
        return result;
    }
    
    
    
}
