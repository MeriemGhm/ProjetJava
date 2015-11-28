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
public interface MannequinFacadeLocal {

    void create(Mannequin mannequin);

    void edit(Mannequin mannequin);

    void remove(Mannequin mannequin);

    Mannequin find(Object id);

    List<Mannequin> findAll();

    List<Mannequin> findRange(int[] range);

    int count();

    void creerMannequin(String nom, String prenom, String adresse, String telephone, String login, String password, double salaire);
    
}
