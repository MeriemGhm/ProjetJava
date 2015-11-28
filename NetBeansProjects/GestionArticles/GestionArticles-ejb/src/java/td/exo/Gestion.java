/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exo;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Meriem
 */
@Stateless
public class Gestion implements GestionLocal {
    @EJB
    private FraicheurFacadeLocal fraicheurFacade;
    @EJB
    private VetementFacadeLocal vetementFacade;
    @EJB
    private ArticleFacadeLocal articleFacade;
    @EJB
    private FournisseurFacadeLocal fournisseurFacade;

    @Override
    public void creerFournisseur(String n, String a, String t) {
        if(n!=null && a!=null && t!=null){
            fournisseurFacade.creerFournisseur(n, a, t);
        }
    }

    @Override
    public java.util.List<Fournisseur> afficherFournisseurs() {
        List<Fournisseur> result = fournisseurFacade.afficherFournisseurs();
        return result;
    }

    @Override
    public void creerArticle(String des, double prix, String type, long id_four) {
        Fournisseur f = fournisseurFacade.rechercherFournisseur(id_four);
        if(des!=null && prix!=0 && type!=null && f!=null){
            articleFacade.creerArticle(des, prix, type, f);
        } 
    }

    @Override
    public void creerVetement(String des, double prix, String type, long id_four, String colori) {
        Fournisseur f = fournisseurFacade.rechercherFournisseur(id_four);
        if(des!=null && prix!=0 && type!=null && f!=null){
            vetementFacade.creerVetement(des, prix, type, f, colori);
        }
    }

    @Override
    public void creerFraicheur(String des, double prix, String type, long id_four, Date date_limite) {
        Fournisseur f = fournisseurFacade.rechercherFournisseur(id_four);
        if(des!=null && prix!=0 && type!=null && f!=null){
            fraicheurFacade.creerFraicheur(des, prix, type, f, date_limite);
        }
        
    }

    @Override
    public java.util.List<Article> rechercherArticlesFrs(long id_four) {
        Fournisseur f = fournisseurFacade.rechercherFournisseur(id_four);
        List<Article> result = articleFacade.rechercherArticle(f);
        return result;
    }

    @Override
    public java.util.List<Vetement> rechercherVetementsFrs(long id_four) {
        Fournisseur f = fournisseurFacade.rechercherFournisseur(id_four);
        List<Vetement> result = vetementFacade.rechercherVetement(f);
        return result;
    }

    @Override
    public java.util.List<Fraicheur> rechercherFraicheurFrs(long id_four) {
        Fournisseur f = fournisseurFacade.rechercherFournisseur(id_four);
        List<Fraicheur> result = fraicheurFacade.rechercherFraicheur(f);
        return result;
    }

    
    
   
}
