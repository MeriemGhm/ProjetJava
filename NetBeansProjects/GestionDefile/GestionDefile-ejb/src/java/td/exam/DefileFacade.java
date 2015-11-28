/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam;

import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Meriem
 */
@Stateless
public class DefileFacade extends AbstractFacade<Defile> implements DefileFacadeLocal {
    @PersistenceContext(unitName = "GestionDefile-ejbPU")
    private EntityManager em;

    
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DefileFacade() {
        super(Defile.class);
    }

    @Override
    public void creerDefile(Date dateDefile, String nom, Organisateur organisateur, Lieu lieu, Couturier couturier) {
        Defile d = new Defile();
        d.setDateDefile(dateDefile);
        d.setNom(nom);
        d.setOrganisateur(organisateur);
        d.setLieu(lieu);
        d.setCouturier(couturier);
        getEntityManager().persist(d);
    }
    
    
    //Rechercher défilé en fonction d'un lieu
    //Rechercher défilé en fonction d'un couturier
    //Rechercher défilé en fonction d'une date
    //Rechercher défilé en fonction d'une intervalle de dates
    //Rechercher défilé en fonction d'un mannequin
    //Rechercher défilé en fonction de son coût
    //Estimer coût d'un défilé
}
