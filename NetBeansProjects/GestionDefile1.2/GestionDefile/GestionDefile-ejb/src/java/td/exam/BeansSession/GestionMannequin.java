/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam.BeansSession;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import td.exam.BeansEntite.Personne;

/**
 *
 * @author Meriem
 */
@Stateful
public class GestionMannequin implements GestionMannequinLocal {
    // Accès au bean session GestionPublic
    @EJB
    private GestionPublicLocal gestionPublic;
    
    private Personne personne;

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    
    //Recherche des vêtements et accessoires qu'ils doivent porter + position dans le défilé
    // !!!!!SEULEMENT CEUX LE CONCERNANT!!!!
}
