/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Meriem
 */
@Entity
public class Defile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDefile;
    private String nom;
    @ManyToMany
    private List<Mannequin> mannequins= new ArrayList<Mannequin>();
    @ManyToOne
    private Organisateur organisateur;
    @ManyToOne
    private Lieu lieu;
    @ManyToOne
    private Couturier couturier;



    public Long getId() {
        return id;
    }
    
    public Date getDateDefile() {
        return dateDefile;
    }

    public String getNom() {
        return nom;
    }
    
    public List<Mannequin> getMannequins() {
        return mannequins;
    }
    
    public Organisateur getOrganisateur() {
        return organisateur;
    }
    
    public Lieu getLieu() {
        return lieu;
    }
    
    public Couturier getCouturier() {
        return couturier;
    }
    
    
    
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setDateDefile(Date dateDefile) {
        this.dateDefile = dateDefile;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setMannequins(List<Mannequin> mannequins) {
        this.mannequins = mannequins;
    }

    public void setOrganisateur(Organisateur organisateur) {
        this.organisateur = organisateur;
    }
    
    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }
    
    public void setCouturier(Couturier couturier) {
        this.couturier = couturier;
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
        if (!(object instanceof Defile)) {
            return false;
        }
        Defile other = (Defile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "td.exam.Defile[ id=" + id + " ]";
    }
    
}
