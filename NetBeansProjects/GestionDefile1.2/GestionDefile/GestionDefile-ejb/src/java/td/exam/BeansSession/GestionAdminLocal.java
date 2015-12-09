/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam.BeansSession;

import javax.ejb.Local;

/**
 *
 * @author Meriem
 */
@Local
public interface GestionAdminLocal {

    void creerOrganisateur(String raisonSociale, String adresse, String telephone, String login, String password);

    void creerCouturier(String nom, String prenom, String adresse, String telephone, String login, String password);

    void creerMannequin(String nom, String prenom, String adresse, String telephone, String login, String password, double salaire);
    
}
