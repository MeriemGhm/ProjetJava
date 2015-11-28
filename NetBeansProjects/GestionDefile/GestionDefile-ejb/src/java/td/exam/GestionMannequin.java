/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam;

import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author Meriem
 */
@Stateful
public class GestionMannequin implements GestionMannequinLocal {
    // Accès au bean session GestionPublic
    @EJB
    private GestionPublicLocal gestionPublic;
    
    
    //Recherche des vêtements et accessoires qu'ils doivent porter + position dans le défilé
    // !!!!!SEULEMENT CEUX LE CONCERNANT!!!!
}
