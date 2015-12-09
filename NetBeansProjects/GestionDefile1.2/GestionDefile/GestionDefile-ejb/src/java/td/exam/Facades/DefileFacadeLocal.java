/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam.Facades;

import td.exam.BeansEntite.Couturier;
import td.exam.BeansEntite.Organisateur;
import td.exam.BeansEntite.Lieu;
import td.exam.BeansEntite.Defile;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Meriem
 */
@Local
public interface DefileFacadeLocal {

    void create(Defile defile);

    void edit(Defile defile);

    void remove(Defile defile);

    Defile find(Object id);

    List<Defile> findAll();

    List<Defile> findRange(int[] range);

    int count();

    void creerDefile(Date dateDefile, String nom, Organisateur organisateur, Lieu lieu, Couturier couturier);
    
}
