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
import model.Competence;
import model.CompetenceProfile;

/**
 *
 * @author Semir
 */
@ApplicationScoped
public class CompetenceProfileDAO implements CompetenceProfileDAOInterface {

    @PersistenceContext(unitName = "JobFinderPU")
    private EntityManager em;

    @Override
    public void addCompetenceProfile(CompetenceProfile competencep) {
        em.persist(competencep);
    }

    @Override
    public void removeCompetenceProfile(CompetenceProfile competencep) {
        em.merge(competencep);
        em.remove(competencep);
    }

    @Override
    public CompetenceProfile findByID(long id) {
        return em.find(CompetenceProfile.class, id);
    }

    @Override
    public List<CompetenceProfile> findAll() {
                TypedQuery<CompetenceProfile> query = em.createQuery(
                "SELECT g FROM CompetenceProfile g", CompetenceProfile.class);
        return query.getResultList();
    }

    @Override
    public CompetenceProfile findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
