/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam.BeansSession;

import java.util.Date;
import javax.ejb.Local;
import td.exam.BeansEntite.Couturier;
import td.exam.BeansEntite.Personne;

/**
 *
 * @author Meriem
 */
@Local
public interface GestionCouturierLocal {
    
    void setPersonne(Personne p);
    
    Personne getPersonne();

    void creerVetement(Date dateCreation, String libelle, Couturier couturier, String taille, String colori, String matiere, int position);
}
