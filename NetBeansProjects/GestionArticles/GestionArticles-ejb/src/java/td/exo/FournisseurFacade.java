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
public class FournisseurFacade extends AbstractFacade<Fournisseur> implements FournisseurFacadeLocal {
    @PersistenceContext(unitName = "GestionArticles-ejbPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void creerFournisseur(String nom, String adresse, String type) {
        Fournisseur f = new Fournisseur();
        f.setNom(nom);
        f.setAdresse(adresse);
        f.setType(type);
        getEntityManager().persist(f);
    } 
    
    @Override
    public java.util.List<Fournisseur> afficherFournisseurs() {
        String txt = "SELECT f FROM Fournisseur as f";
        Query req = getEntityManager().createQuery(txt);
        List<Fournisseur> result = req.getResultList();
        return result;
    }
    
    
    
    public FournisseurFacade() {
        super(Fournisseur.class);
    }

    @Override
    public Fournisseur rechercherFournisseur(long id) {
        String txt = "SELECT f FROM Fournisseur as f WHERE f.id =:ident";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("ident", id);
        Fournisseur result = (Fournisseur)req.getSingleResult();
        return result;
    }

    

    
    
}
