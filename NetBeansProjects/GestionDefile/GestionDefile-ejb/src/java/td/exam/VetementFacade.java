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
public class VetementFacade extends AbstractFacade<Vetement> implements VetementFacadeLocal {
    @PersistenceContext(unitName = "GestionDefile-ejbPU")
    private EntityManager em;

    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VetementFacade() {
        super(Vetement.class);
    }

    @Override
    public void creerVetement(Date dateCreation, String libelle, Couturier couturier, Mannequin mannequin, String taille, String colori, String matiere, int position) {
        Vetement v = new Vetement();
        v.setDateCreation(dateCreation);
        v.setColori(colori);
        v.setLibelle(libelle);
        v.setCouturier(couturier);
        v.setMannequin(mannequin);
        v.setMatiere(matiere);
        v.setPosition(position);
        v.setTaille(taille);
        getEntityManager().persist(v);
    }
    
    //Rechercher des vetements en fonction du mannequin 
    //Rechercher les vêtements d'un défilé
    //Rechercher les vêtements d'un couturier
    
}
