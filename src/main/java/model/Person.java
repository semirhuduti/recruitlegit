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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Semir
 */
@Entity
@Table(catalog = "recruit", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByPersonId", query = "SELECT p FROM Person p WHERE p.personId = :personId"),
    @NamedQuery(name = "Person.findByFirstname", query = "SELECT p FROM Person p WHERE p.name = :name"),
    @NamedQuery(name = "Person.findBySurname", query = "SELECT p FROM Person p WHERE p.surname = :surname"),
    @NamedQuery(name = "Person.findBySsn", query = "SELECT p FROM Person p WHERE p.ssn = :ssn"),
    @NamedQuery(name = "Person.findByEmail", query = "SELECT p FROM Person p WHERE p.email = :email"),
    @NamedQuery(name = "Person.findByUserpassword", query = "SELECT p FROM Person p WHERE p.password = :password"),
    @NamedQuery(name = "Person.findByUsername", query = "SELECT p FROM Person p WHERE p.username = :username")})
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "person_id", nullable = false)
    private Long personId;
    @Size(max = 255)
    @Column(length = 255)
    private String name;
    @Size(max = 255)
    @Column(length = 255)
    private String surname;
    @Size(max = 255)
    @Column(length = 255)
    private String ssn;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(length = 255)
    private String email;
    @Size(max = 255)
    @Column(length = 255)
    private String password;
    @Size(max = 255)
    @Column(length = 255)
    private String username;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne
    private Role roleId;
    @OneToMany(mappedBy = "personId")
    private Collection<CompetenceProfile> competenceProfileCollection;
    @OneToMany(mappedBy = "personId")
    private Collection<Availability> availabilityCollection;

    /**
     * The Constructor whithout any parameters
     */
    public Person() {}

    /**
     * The constructor taking a long to use as the PK when stored in the 
     * database
     * 
     * @param personId  Long to be used as PK
     */
    public Person(Long personId) {
        this.personId = personId;
    }

    /**
     * Gets the personId which is the PK for the entity
     * 
     * @return  The entitys PK, personId
     */
    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

     /**
     * Gets the person's name
     * 
     * @return The person's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the person's Name
     * 
     * @param name The person's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *  Gets the person's surname
     * 
     * @return The person's surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     *  Sets the person's surname
     * 
     * @param surname person's surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets the person's social security number
     * 
     * @return The person's social security number
     */
    public String getSsn() {
        return ssn;
    }

     /**
     *  Sets the person's social security number
     * 
     * @param ssn The peron's social security number
     */
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    /**
     * Gets the person's email
     * 
     * @return The person's email
     */
    public String getEmail() {
        return email;
    }

    /**
     *  Sets the person's email
     * 
     * @param email The person's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the person's password
     * 
     * @return The person's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the person's password
     * 
     * @param password The person's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the person's username
     * 
     * @return The person's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the person's username
     * 
     * @param username The person's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the foreign key of roles.
     * 
     * @return  The role id
     */
    public Role getRoleId() {
        return roleId;
    }

    /**
     * Sets the foreign key roleId.
     * 
     * @param roleId The new roleId.
     */
    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @XmlTransient
    public Collection<CompetenceProfile> getCompetenceProfileCollection() {
        return competenceProfileCollection;
    }

    public void setCompetenceProfileCollection(Collection<CompetenceProfile> competenceProfileCollection) {
        this.competenceProfileCollection = competenceProfileCollection;
    }

    @XmlTransient
    public Collection<Availability> getAvailabilityCollection() {
        return availabilityCollection;
    }

    public void setAvailabilityCollection(Collection<Availability> availabilityCollection) {
        this.availabilityCollection = availabilityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personId != null ? personId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Person[ personId=" + personId + " ]";
    }
    
}
