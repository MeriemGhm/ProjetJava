/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exo;

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

    void creerVetement(String designation, double prix, String type, Fournisseur fournisseur, String colori);

    java.util.List<Vetement> rechercherVetement(Fournisseur fournisseur);
    
}
