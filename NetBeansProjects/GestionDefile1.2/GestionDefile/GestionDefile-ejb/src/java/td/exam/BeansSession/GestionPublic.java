/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam.BeansSession;

import td.exam.Facades.PersonneFacadeLocal;
import td.exam.BeansEntite.Personne;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author Meriem
 */
@Stateful
public class GestionPublic implements GestionPublicLocal {
    @EJB
    private PersonneFacadeLocal personneFacade;
    
    private Personne p;

    @Override
    public Personne getP() {
        return p;
    }

    @Override
    public void setP(Personne p) {
        this.p = p;
    }

    // Méthodes accessibles au public :
        //Recherches affichent les défilés à venir ou passés avec liste des détails (dates, lieu couturier et mannequins)
        //Résultat triés sur la date
    //Rechercher défilé en fonction d'un lieu 
    //Rechercher défilé en fonction d'une date 
    //Rechercher défilé en fonction d'une intervalle de dates 
    //Rechercher défilé en fonction d'un couturier 
    //Rechercher défilé en fonction d'un mannequin
    //Rechercher défilé en fonction de son coût (approximatif)
    
    //Méthode pour autheentification : recherche de l'instance personne 
    @Override
    public Personne authentification(String login, String password) {
        Personne p;
        
        if(login != null && password != null && !login.isEmpty() && !password.isEmpty()){
            
            p = personneFacade.recherchePersonne(login);
            
            if(p != null){
                
                if(p.getPassword().equals(password)){
                    return p; 
                }else{
                    System.out.print("Mot de passe érroné, réesayez");
                    return null;
                }
                
            }else{
                System.out.print("Identifiant erronné, réessayez.");
                return null;
            }
        }else{
            System.out.print("Veuillez saisir vos identifiants.");
            return null;
        }
    }
}
