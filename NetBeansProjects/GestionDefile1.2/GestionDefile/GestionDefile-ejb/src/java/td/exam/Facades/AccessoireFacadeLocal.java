/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam.Facades;

import td.exam.BeansEntite.Accessoire;
import td.exam.BeansEntite.Vetement;
import java.util.List;
import javax.ejb.Local;
import td.exam.Enum.TypeAccessoire;

/**
 *
 * @author Meriem
 */
@Local
public interface AccessoireFacadeLocal {

    void create(Accessoire accessoire);

    void edit(Accessoire accessoire);

    void remove(Accessoire accessoire);

    Accessoire find(Object id);

    List<Accessoire> findAll();

    List<Accessoire> findRange(int[] range);

    int count();

    void creerAccessoire(TypeAccessoire type, double prixAchat, double prixLocation, double prixAssurance, Vetement vetement);

    java.util.List<Accessoire> rechercheAccessoire(Vetement vetement);
    
}
