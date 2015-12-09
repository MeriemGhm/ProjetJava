/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam.BeansSession;

import javax.ejb.Local;
import td.exam.BeansEntite.Personne;

/**
 *
 * @author Meriem
 */
@Local
public interface GestionMannequinLocal {
    
    void setPersonne(Personne p);
}
