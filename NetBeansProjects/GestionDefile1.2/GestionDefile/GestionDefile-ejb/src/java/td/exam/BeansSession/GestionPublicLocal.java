/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam.BeansSession;

import td.exam.BeansEntite.Personne;
import javax.ejb.Local;

/**
 *
 * @author Meriem
 */
@Local
public interface GestionPublicLocal {

    Personne authentification(String login, String password);

    public Personne getP();

    public void setP(Personne p);
    
}
