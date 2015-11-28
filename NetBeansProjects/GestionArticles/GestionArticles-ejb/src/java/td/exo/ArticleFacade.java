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
public class ArticleFacade extends AbstractFacade<Article> implements ArticleFacadeLocal {
    @PersistenceContext(unitName = "GestionArticles-ejbPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticleFacade() {
        super(Article.class);
    }

   
    @Override
    public void creerArticle(String designation, double prix, String type, Fournisseur fournisseur) {
        Article a = new Article();
        a.setDesignation(designation);
        a.setPrix(prix);
        a.setType(type);
        a.setLeFournisseur(fournisseur);
        getEntityManager().persist(a);
    }

    @Override
    public java.util.List<Article> rechercherArticle(Fournisseur fournisseur) {
        String txt = "SELECT a FROM Article AS a WHERE a.leFournisseur =:f";
        Query req = em.createQuery(txt);
        req.setParameter("f", fournisseur);
        List<Article> result = req.getResultList();
        return result;
    }
    
    
    
}
