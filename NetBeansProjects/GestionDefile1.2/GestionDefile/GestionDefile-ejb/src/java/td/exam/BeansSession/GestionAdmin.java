/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam.BeansSession;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import td.exam.Facades.CouturierFacadeLocal;
import td.exam.Facades.MannequinFacadeLocal;
import td.exam.Facades.OrganisateurFacadeLocal;

/**
 *
 * @author Meriem
 */
@Stateful
public class GestionAdmin implements GestionAdminLocal {
    @EJB
    private MannequinFacadeLocal mannequinFacade;
    @EJB
    private OrganisateurFacadeLocal organisateurFacade;
    @EJB
    private CouturierFacadeLocal couturierFacade;
    
    // Méthodes de création de comptes (Couturier, Organisateur, Mannequin)

    @Override
    public void creerOrganisateur(String raisonSociale, String adresse, String telephone, String login, String password) {
        if(adresse != null && telephone != null && raisonSociale != null && login != null && password != null){
            organisateurFacade.creerOrganisateur(raisonSociale, adresse, telephone, login, password);
        }
    }

    @Override
    public void creerCouturier(String nom, String prenom, String adresse, String telephone, String login, String password) {
        if(adresse != null && telephone != null && nom != null && login != null && password != null && prenom != null){
            couturierFacade.creerCouturier(nom, prenom, adresse, telephone, login, password);
        }
    }

    @Override
    public void creerMannequin(String nom, String prenom, String adresse, String telephone, String login, String password, double salaire) {
        if(adresse != null && telephone != null && nom != null && login != null && password != null && prenom != null){
            mannequinFacade.creerMannequin(nom, prenom, adresse, telephone, login, password, salaire);
        }
    }
    
    
    
    
    
}
