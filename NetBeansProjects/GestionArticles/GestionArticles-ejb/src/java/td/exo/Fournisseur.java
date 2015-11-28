/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Meriem
 */
@Entity
public class Fournisseur implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String adresse;
    private String type;
    @OneToMany(mappedBy = "leFournisseur")
    private List<Article> articles;

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
    
    public String getAdresse() {
        return adresse;
    }
    
    public String getType() {
        return type;
    }
    
    ///////////////////////////////////////////////////////////////
    
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setType(String type) {
        this.type = type;
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
        if (!(object instanceof Fournisseur)) {
            return false;
        }
        Fournisseur other = (Fournisseur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "td.exo.Fournisseur[ id=" + id + " ]";
    }
    
}
