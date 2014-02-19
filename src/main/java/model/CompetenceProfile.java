/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Semir
 */
@Entity
@Table(name = "competence_profile", catalog = "recruit", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompetenceProfile.findAll", query = "SELECT c FROM CompetenceProfile c"),
    @NamedQuery(name = "CompetenceProfile.findByCompetenceProfileId", query = "SELECT c FROM CompetenceProfile c WHERE c.competenceProfileId = :competenceProfileId"),
    @NamedQuery(name = "CompetenceProfile.findByYearsOfExperience", query = "SELECT c FROM CompetenceProfile c WHERE c.yearsOfExperience = :yearsOfExperience")})
public class CompetenceProfile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "competence_profile_id", nullable = false)
    private Long competenceProfileId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "years_of_experience", precision = 4, scale = 2)
    private BigDecimal yearsOfExperience;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne
    private Person personId;
    @JoinColumn(name = "competence_id", referencedColumnName = "competence_id")
    @ManyToOne
    private Competence competenceId;

    /**
     * Constructor
     */
    public CompetenceProfile() {
    }

    /**
     * Constructor which takes a Long CompetenceProfileID which is the Entity's 
     * PK when stored in the database
     * 
     * @param competenceProfileId   The PK of the Entity
     */
    public CompetenceProfile(Long competenceProfileId) {
        this.competenceProfileId = competenceProfileId;
    }

    /**
     * Returns the competenceProfileId which is the Entity's PK
     * 
     * @return  Returns the Entity's PK
     */
    public Long getCompetenceProfileId() {
        return competenceProfileId;
    }

    /**
     * Sets the entitys PK to the parameter 
     * 
     * @param competenceProfileId   The new PK for the entity
     */
    public void setCompetenceProfileId(Long competenceProfileId) {
        this.competenceProfileId = competenceProfileId;
    }

    /**
     * Gets the persons years of experience as a BigDeciaml
     * 
     * @return  The user's years of experience
     */
    public BigDecimal getYearsOfExperience() {
        return yearsOfExperience;
    }

    /**
     * Sets the user's years of experience
     * 
     * @param yearsOfExperience The user's years of experience
     */
    public void setYearsOfExperience(BigDecimal yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    /**
     * Sets the foreign key refering to the person the competence profile is 
     * connected to.
     * 
     * @return  Retuurns the Person the competence profile is connected to
     */
    public Person getPersonId() {
        return personId;
    }

    /**
     * Sets the person the profile is connected to.
     * 
     * @param personId  The person the profile should be connected to
     */
    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    /**
     * Returns the foreign key to the competence this entity profile is 
     * connected to.
     * 
     * @return  The competence this Entity is connected to 
     */
    public Competence getCompetenceId() {
        return competenceId;
    }

    /**
     * Sets the foreign key to the competence this profile is connected to.
     * 
     * @param competenceId  The foreign key to the competence connected to this profile
     */
    public void setCompetenceId(Competence competenceId) {
        this.competenceId = competenceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (competenceProfileId != null ? competenceProfileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompetenceProfile)) {
            return false;
        }
        CompetenceProfile other = (CompetenceProfile) object;
        if ((this.competenceProfileId == null && other.competenceProfileId != null) || (this.competenceProfileId != null && !this.competenceProfileId.equals(other.competenceProfileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CompetenceProfile[ competenceProfileId=" + competenceProfileId + " ]";
    }
    
}
