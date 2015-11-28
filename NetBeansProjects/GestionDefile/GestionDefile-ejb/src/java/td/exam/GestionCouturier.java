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
public class GestionCouturier implements GestionCouturierLocal {
    // Accès au bean session GestionPublic
    @EJB
    private GestionPublicLocal gestionPublic;
    
    
    
    //Ajouter un mannequin 
    //Modifier un mannequin 
    //Supprimer un mannequin
    //Ajouter un vetement
    //Modifier un vetement 
    //Supprimer un vetement
    //Ajouter un accessoire
    //Modifier un accessoire 
    //Supprimer un accessoire
    //Modifier la position d'un vêtement dans un défilé 
}
