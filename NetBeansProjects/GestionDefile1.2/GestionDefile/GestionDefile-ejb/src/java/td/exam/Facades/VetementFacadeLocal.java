/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam.Facades;

import td.exam.BeansEntite.Couturier;
import td.exam.BeansEntite.Vetement;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Meriem
 */
@Local
public interface VetementFacadeLocal {

    void create(Vetement vetement);

    void edit(Vetement vetement);

    void remove(Vetement vetement);

    Vetement find(Object id);

    List<Vetement> findAll();

    List<Vetement> findRange(int[] range);

    int count();

    void creerVetement(Date dateCreation, String libelle, Couturier couturier, String taille, String colori, String matiere, int position);
    
}
