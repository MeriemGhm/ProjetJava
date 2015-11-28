/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Meriem
 */
@Stateless
public class OrganisateurFacade extends AbstractFacade<Organisateur> implements OrganisateurFacadeLocal {
    @PersistenceContext(unitName = "GestionDefile-ejbPU")
    private EntityManager em;

    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrganisateurFacade() {
        super(Organisateur.class);
    }

    @Override
    public void creerOrganisateur(String raisonSociale, String adresse, String telephone, String login, String password) {
        Organisateur o = new Organisateur();
        o.setRaisonSociale(raisonSociale);
        o.setAdresse(adresse);
        o.setTelephone(telephone);
        o.setLogin(login);
        o.setPassword(password);
        getEntityManager().persist(o);
    }
    
    //Rechercher un organisateur à partir de son nom/raison sociale
}
