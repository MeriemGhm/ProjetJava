/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam.BeansSession;

import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import td.exam.BeansEntite.Couturier;
import td.exam.BeansEntite.Personne;
import td.exam.Facades.VetementFacadeLocal;

/**
 *
 * @author Meriem
 */
@Stateful
public class GestionCouturier implements GestionCouturierLocal {

    @EJB
    private VetementFacadeLocal vetementFacade;
    @EJB
    private GestionPublicLocal gestionPublic;
    
    private Personne personne;

    @Override
    public Personne getPersonne() {
        return personne;
    }

    @Override
    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

  
    //Ajouter un mannequin 
    //Modifier un mannequin 
    //Supprimer un mannequin
    
    //Modifier un vetement 
    //Supprimer un vetement
    //Ajouter un accessoire
    //Modifier un accessoire 
    //Supprimer un accessoire
    //Modifier la position d'un vêtement dans un défilé 

    
    
    //Ajouter un vetement
    @Override
    public void creerVetement(Date dateCreation, String libelle, Couturier couturier, String taille, String colori, String matiere, int position) {
        vetementFacade.creerVetement(dateCreation, libelle, couturier, taille, colori, matiere, position);
    }
}
