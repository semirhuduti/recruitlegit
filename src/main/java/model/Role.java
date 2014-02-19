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
 *
 * @author Semir
 */
@Entity
@Table(catalog = "recruit", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
    @NamedQuery(name = "Role.findByRoleId", query = "SELECT r FROM Role r WHERE r.roleId = :roleId"),
    @NamedQuery(name = "Role.findByRolename", query = "SELECT r FROM Role r WHERE r.rolename = :rolename")})
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "role_id", nullable = false)
    private Long roleId;
    @Size(max = 255)
    @Column(length = 255)
    private String rolename;
    @OneToMany(mappedBy = "roleId")
    private Collection<Person> personCollection;

    /**
     * The constructor
     */
    public Role() {
    }

    /**
     * The contructor which also takes an Long roleID which wil serve as the PK
     * for this Entity when stored in a database.
     * 
     * @param roleId    A Long used as a PK for the Entity
     */
    public Role(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * Returns the roleId which serves as this entitys PK.
     * 
     * @return  A Long used as this Entitys PK
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * Sets this Entitys PK to the value of the parameter.
     * 
     * @param roleId    This entitys new PK.
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * Returns the name of the role.
     * 
     * @return The name of the Role
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * Sets the name of the role.
     * 
     * @param rolename  The new name of the role
     */
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    /**
     * Returns the collection of people assigned to this role
     * 
     * @return  Collection of people assigned to this role
     */
    @XmlTransient
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    /**
     * Sets a collection of persons to be assigned to this role.
     * 
     * @param personCollection  A collecton of people to be assigned to this role
     */
    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Role[ roleId=" + roleId + " ]";
    }
    
}
