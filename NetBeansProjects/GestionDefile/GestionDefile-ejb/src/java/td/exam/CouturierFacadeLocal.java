/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Meriem
 */
@Local
public interface CouturierFacadeLocal {

    void create(Couturier couturier);

    void edit(Couturier couturier);

    void remove(Couturier couturier);

    Couturier find(Object id);

    List<Couturier> findAll();

    List<Couturier> findRange(int[] range);

    int count();

    void creerCouturier(String nom, String prenom, String adresse, String telephone, String login, String password);

    java.util.List<Couturier> rechercheCourturier(String nom);
    
}
