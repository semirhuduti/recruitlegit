/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import model.Person;
import model.Role;

/**
 *
 * @author Semir
 */
@ApplicationScoped
public class PersonDAO implements PersonDAOInterface {

    @PersistenceContext(unitName = "JobFinderPU")
    private EntityManager em;

    public PersonDAO() {

    }

    @Override
    public void addPerson(Person person) {
        System.out.println("Person in DAO" + person.toString());
        System.out.println("EM null ? " + (em==null));
        em.persist(person);

    }

    @Override
    public List<Person> findAll() {
        TypedQuery<Person> query = em.createQuery(
                "SELECT g FROM Person g", Person.class);
        return query.getResultList();
    }

    @Override
    public void removePerson(Person person) {
        em.merge(person);
        em.remove(person);
    }

    @Override
    public Person findByID(long id) {
        return em.find(Person.class, id);

    }
}
