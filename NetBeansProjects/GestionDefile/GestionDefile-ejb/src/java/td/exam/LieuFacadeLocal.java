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
public interface LieuFacadeLocal {

    void create(Lieu lieu);

    void edit(Lieu lieu);

    void remove(Lieu lieu);

    Lieu find(Object id);

    List<Lieu> findAll();

    List<Lieu> findRange(int[] range);

    int count();

    void creerLieu(String nom, String adresse);
    
}
