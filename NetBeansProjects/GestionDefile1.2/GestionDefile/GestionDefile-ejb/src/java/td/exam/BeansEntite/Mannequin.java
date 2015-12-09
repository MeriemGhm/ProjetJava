/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam.BeansEntite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Meriem
 */
@Entity
public class Mannequin extends Personne implements Serializable {
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double salaire;
    @ManyToMany(mappedBy = "mannequins")
    private List<Defile> defiles= new ArrayList<Defile>();
    @OneToMany(mappedBy = "mannequin")
    private List<Vetement> vetements = new ArrayList<Vetement>();
    
    
    @Override
    public Long getId() {
        return id;
    }

    public double getSalaire() {
        return salaire;
    }
    
    public List<Defile> getDefile(){
        return this.defiles;
    }
    
    
    
    
    
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
    
    public void setDefiles(List<Defile> defiles){
        this.defiles = defiles;
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
        if (!(object instanceof Mannequin)) {
            return false;
        }
        Mannequin other = (Mannequin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "td.exam.Mannequin[ id=" + id + " ]";
    }
    
}
