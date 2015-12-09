/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam.Facades;

import td.exam.BeansEntite.Organisateur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Meriem
 */
@Local
public interface OrganisateurFacadeLocal {

    void create(Organisateur organisateur);

    void edit(Organisateur organisateur);

    void remove(Organisateur organisateur);

    Organisateur find(Object id);

    List<Organisateur> findAll();

    List<Organisateur> findRange(int[] range);

    int count();

    void creerOrganisateur(String raisonSociale, String adresse, String telephone, String login, String password);
    
}
