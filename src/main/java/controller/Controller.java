/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import model.DAO.PersonDAO;
import model.DAO.RoleDAO;
import model.Person;
import model.Role;

/**
 *
 * @author Semir
 */
@Stateless
public class Controller {
   
    @Inject
    PersonDAO persondao;
    @Inject
    RoleDAO roledao;

    public Controller() {

    }

    public void addPerson(String firstname, String surname, String username, String password, String email, String ssn) {
        Person person = new Person();

        person.setFirstname(firstname);
        person.setSurname(surname);
        person.setUsername(username);
        person.setUserpassword(password);
        person.setEmail(email);
        person.setSsn(ssn);
        person.setPersonId((long) 1);
        Role role = roledao.findByID(3);
        
        person.setRoleId(role);
        System.out.println("Person to be added to the pu : " + person.toString());

        persondao.addPerson(person);
    }

}
