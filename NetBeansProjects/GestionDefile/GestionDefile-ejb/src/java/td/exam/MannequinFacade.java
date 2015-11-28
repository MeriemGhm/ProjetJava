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
public class MannequinFacade extends AbstractFacade<Mannequin> implements MannequinFacadeLocal {
    @PersistenceContext(unitName = "GestionDefile-ejbPU")
    private EntityManager em;

    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MannequinFacade() {
        super(Mannequin.class);
    }

    @Override
    public void creerMannequin(String nom, String prenom, String adresse, String telephone, String login, String password, double salaire) {
        Mannequin m = new Mannequin();
        m.setNom(nom);
        m.setPrenom(prenom);
        m.setAdresse(adresse);
        m.setTelephone(telephone);
        m.setLogin(login);
        m.setPassword(password);
        m.setSalaire(salaire);
        getEntityManager().persist(m);
    }
    
    //Recherche d'un mannequin en fonction de son nom
    
}
