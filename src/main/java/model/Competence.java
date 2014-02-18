/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The Entity class which is used to store and modify a recruit's competence.
 * 
 * @author Semir, Dan, Milos
 */
@Entity
@Table(catalog = "recruit", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Competence.findAll", query = "SELECT c FROM Competence c"),
    @NamedQuery(name = "Competence.findByCompetenceId", query = "SELECT c FROM Competence c WHERE c.competenceId = :competenceId"),
    @NamedQuery(name = "Competence.findByCompetenceName", query = "SELECT c FROM Competence c WHERE c.competenceName = :competenceName")})
public class Competence implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "competence_id", nullable = false)
    private Long competenceId;
    @Size(max = 255)
    @Column(name = "competence_name", length = 255)
    private String competenceName;
    @OneToMany(mappedBy = "competenceId")
    private Collection<CompetenceProfile> competenceProfileCollection;

    /**
     * The constructor
     */
    public Competence() {
    }

    /**
     * Constructor which takes a long as a parameter which is used as a PK when 
     * it is stored in the database.
     * 
     * @param competenceId  Long which is used as a PK in the database
     */
    public Competence(Long competenceId) {
        this.competenceId = competenceId;
    }

    /**
     * Get's the Long competenceId which is the Entity's PK
     * 
     * @return  The entity's PK
     */
    public Long getCompetenceId() {
        return competenceId;
    }

    /**
     * Set's the Entity's PK
     * 
     * @param competenceId  The Entity's PK
     */
    public void setCompetenceId(Long competenceId) {
        this.competenceId = competenceId;
    }

    /**
     * Get's the name of the competence profile
     * 
     * @return  Name of the competence profile
     */
    public String getCompetenceName() {
        return competenceName;
    }

    /**
     * Sets the name of the Competence profile
     * 
     * @param competenceName    Name of the competence profile
     */
    public void setCompetenceName(String competenceName) {
        this.competenceName = competenceName;
    }

    /**
     * Returns a Competence profile of the person
     * 
     * @return  A collection whith the different profiles of competence 
     */
    @XmlTransient
    public Collection<CompetenceProfile> getCompetenceProfileCollection() {
        return competenceProfileCollection;
    }

    /**
     * Sets the competence profile for the Entity.
     * 
     * @param competenceProfileCollection   A collection of competence profiles
     */
    public void setCompetenceProfileCollection(Collection<CompetenceProfile> competenceProfileCollection) {
        this.competenceProfileCollection = competenceProfileCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (competenceId != null ? competenceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competence)) {
            return false;
        }
        Competence other = (Competence) object;
        if ((this.competenceId == null && other.competenceId != null) || (this.competenceId != null && !this.competenceId.equals(other.competenceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Competence[ competenceId=" + competenceId + " ]";
    }
    
}
