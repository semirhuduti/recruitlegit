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
import model.Availability;
import model.Competence;

/**
 *
 * @author Semir
 */
@ApplicationScoped
public class AvailabilityDAO implements AvailabilityDAOInterface {

    @PersistenceContext(unitName = "JobFinderPU")
    private EntityManager em;

    @Override
    public void addAvailability(Availability availability) {
        em.persist(availability);
    }

    @Override
    public void removeAvailability(Availability availability) {
        em.merge(availability);
        em.remove(availability);
    }

    @Override
    public Availability findByID(long id) {
        return em.find(Availability.class, id);
    }

    @Override
    public List<Availability> findAll() {
        TypedQuery<Availability> query = em.createQuery(
                "SELECT g FROM Availibility g", Availability.class);
        return query.getResultList();
    }

}
