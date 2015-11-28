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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Meriem
 */
@Entity
public class Vetement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreation;
    private String taille;
    private String colori;
    private String matiere;
    @ManyToOne
    private Couturier couturier;
    @ManyToOne
    private Mannequin mannequin;
    @OneToMany(mappedBy = "vetement")
    private List<Accessoire> lesAccessoires = new ArrayList<Accessoire>();
    private String libelle;
    private int position;

    

    
    public Long getId() {
        return id;
    }
    
    public Date getDateCreation() {
        return dateCreation;
    }

    public String getTaille() {
        return taille;
    }
    
    public String getColori() {
        return colori;
    }
    
    public String getMatiere() {
        return matiere;
    }
    
    public Couturier getCouturier() {
        return couturier;
    }
    
    public Mannequin getMannequin() {
        return mannequin;
    }
    
    public List<Accessoire> getLesAccessoires() {
        return lesAccessoires;
    }
    
    public String getLibelle() {
        return libelle;
    }
    
    public int getPosition() {
        return position;
    }
    
    
    
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public void setColori(String colori) {
        this.colori = colori;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public void setCouturier(Couturier couturier) {
        this.couturier = couturier;
    }

    public void setMannequin(Mannequin mannequin) {
        this.mannequin = mannequin;
    }
    
    public void setLesAccessoires(List<Accessoire> lesAccessoires) {
        this.lesAccessoires = lesAccessoires;
    }
    
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    public void setPosition(int position) {
        this.position = position;
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
        if (!(object instanceof Vetement)) {
            return false;
        }
        Vetement other = (Vetement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "td.exam.Vetement[ id=" + id + " ]";
    }
    
}
