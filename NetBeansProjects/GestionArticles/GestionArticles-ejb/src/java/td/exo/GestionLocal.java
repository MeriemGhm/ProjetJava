/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exo;

import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Meriem
 */
@Local
public interface GestionLocal {

    void creerFournisseur(String n, String a, String t);

    java.util.List<Fournisseur> afficherFournisseurs();

    void creerArticle(String designation, double prix, String type, long id_four);

    void creerVetement(String designation, double prix, String type, long id_four, String colori);

    void creerFraicheur(String des, double prix, String type, long id_four, Date date_limite);

    java.util.List<Article> rechercherArticlesFrs(long id_four);

    java.util.List<Vetement> rechercherVetementsFrs(long id_four);

    java.util.List<Fraicheur> rechercherFraicheurFrs(long id_four);
    
}
