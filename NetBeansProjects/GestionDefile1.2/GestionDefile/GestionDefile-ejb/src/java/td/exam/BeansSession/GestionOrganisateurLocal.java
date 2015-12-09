/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam.BeansSession;

import java.util.Date;
import javax.ejb.Local;
import td.exam.BeansEntite.Couturier;
import td.exam.BeansEntite.Lieu;
import td.exam.BeansEntite.Organisateur;
import td.exam.BeansEntite.Personne;

/**
 *
 * @author 3097376
 */
@Local
public interface GestionOrganisateurLocal {
    
    Personne getPersonne();
    
    void setPersonne(Personne p);

    void creerDefile(Date dateDefile, String nom, Organisateur organisateur, Lieu lieu, Couturier couturier);
    
}
