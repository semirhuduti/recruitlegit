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

/**
 *
 * @author Semir
 */
@ApplicationScoped
public class CompetenceDAO implements CompetenceDAOInterface {

    @PersistenceContext(unitName = "JobFinderPU")
    private EntityManager em;

    @Override
    public void addCompetence(Competence competence) {
        em.persist(competence);
    }

    @Override
    public void removeCompetence(Competence competence) {
        em.merge(competence);
        em.remove(competence);
    }

    @Override
    public Competence findByID(long id) {
        return em.find(Competence.class, id);
    }

    @Override
    public List<Competence> findAll() {
        TypedQuery<Competence> query = em.createQuery(
                "SELECT g FROM Competence g", Competence.class);
        return query.getResultList();
    }

}
