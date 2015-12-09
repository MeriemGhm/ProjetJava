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
import td.exam.BeansEntite.Lieu;
import td.exam.BeansEntite.Organisateur;
import td.exam.BeansEntite.Personne;
import td.exam.Facades.DefileFacadeLocal;

/**
 *
 * @author 3097376
 */
@Stateful
public class GestionOrganisateur implements GestionOrganisateurLocal {

    @EJB
    private DefileFacadeLocal defileFacade;
    
    private Personne personne;

    @Override
    public Personne getPersonne() {
        return personne;
    }

    @Override
    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    @Override
    public void creerDefile(Date dateDefile, String nom, Organisateur organisateur, Lieu lieu, Couturier couturier) {
        defileFacade.creerDefile(dateDefile, nom, organisateur, lieu, couturier);
    }

    
}
