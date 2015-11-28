/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Meriem
 */
@Entity
public class Organisateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String raisonSociale;
    @Column(nullable = false, unique=true)
    private String login;
    @Column(nullable=false)
    private String password;
    private String adresse;
    private String telephone;

    

    


    
    public Long getId() {
        return id;
    }
    
    public String getRaisonSociale() {
        return raisonSociale;
    }

    public String getLogin() {
        return login;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getAdresse() {
        return adresse;
    }
    
    public String getTelephone() {
        return telephone;
    }
    
    
    
    
    
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public void setLogin(String login) {
        this.login = login;
    }
  
    public void setPassword(String password) {
        this.password = password;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organisateur)) {
            return false;
        }
        Organisateur other = (Organisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "td.exam.Organisateur[ id=" + id + " ]";
    }
    
}
