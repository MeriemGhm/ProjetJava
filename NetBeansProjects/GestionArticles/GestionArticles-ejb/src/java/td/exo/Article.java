/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

/**
 *
 * @author Meriem
 */
@Entity
@Inheritance (strategy=InheritanceType.JOINED)
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String designation;
    private double prix;
    private String type;
    @ManyToOne
    private Fournisseur leFournisseur;

 
    public Long getId() {
        return id;
    }
    
    public String getDesignation() {
        return designation;
    }
    
    public double getPrix() {
        return prix;
    }
    
    public String getType() {
        return type;
    }
    
    public Fournisseur getLeFournisseur() {
        return leFournisseur;
    }
    
    ///////////////////////////////////////////////////////////////////

    public void setId(Long id) {
        this.id = id;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public void setLeFournisseur(Fournisseur leFournisseur) {
        this.leFournisseur = leFournisseur;
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
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "td.exo.Article[ id=" + id + " ]";
    }
    
}
