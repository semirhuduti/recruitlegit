/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.Person;
import model.Role;

/**
 *
 * @author Semir
 */
@ApplicationScoped
public class RoleDAO implements RoleDAOInterface {

    @PersistenceContext(unitName = "JobFinderPU")
    private EntityManager em;

    public RoleDAO() {

    }

    @Override
    public void addRole(Role role) {
        System.out.println("Role in DAO" + role.toString());
        System.out.println("EM null ? " + (em==null));
        em.persist(role);

    }

    @Override
    public List<Role> findAll() {
        TypedQuery<Role> query = em.createQuery(
                "SELECT g FROM Role g", Role.class);
        return query.getResultList();
    }

    @Override
    public void removeRole(Role role) {
        em.merge(role);
        em.remove(role);
    }

    @Override
    public Role findByID(long id) {
        return em.find(Role.class, id);

    }
}
