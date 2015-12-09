/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam.BeansEntite;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import td.exam.Enum.TypeAccessoire;

/**
 *
 * @author Meriem
 */
@Entity
public class Accessoire implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private TypeAccessoire type;
    private double prixAchat;
    private double prixLocation;
    private double prixAssurance;
    @ManyToOne
    private Vetement vetement;
    private String libelle;

    
    
    public Long getId() {
        return id;
    }

    public TypeAccessoire getType() {
        return type;
    }
    
    public double getPrixAchat() {
        return prixAchat;
    }
    
    public double getPrixLocation() {
        return prixLocation;
    }
    
    public double getPrixAssurance() {
        return prixAssurance;
    }

    public Vetement getVetement() {
        return vetement;
    }

    public String getLibelle() {
        return libelle;
    }
    
    
    
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setType(TypeAccessoire type) {
        this.type = type;
    }
    
    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }
    
    public void setPrixLocation(double prixLocation) {
        this.prixLocation = prixLocation;
    }
    
    public void setPrixAssurance(double prixAssurance) {
        this.prixAssurance = prixAssurance;
    }

    public void setVetement(Vetement vetement) {
        this.vetement = vetement;
    }
    
    public void setLibelle(String libelle) {
        this.libelle = libelle;
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
        if (!(object instanceof Accessoire)) {
            return false;
        }
        Accessoire other = (Accessoire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "td.exam.Accessoire[ id=" + id + " ]";
    }
    
}
