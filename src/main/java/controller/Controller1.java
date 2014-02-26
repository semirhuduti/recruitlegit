/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DTOs.PersonDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import model.Availability;
import model.Competence;
import model.DAO.CompetenceDAO;
import model.DAO.PersonDAO;
import model.DAO.RoleDAO;
import model.Person;
import model.Role;
import view.CompetenceBean.CompetenceHolder;

/**
 * Controller class which handles all calls from the RegisterBean class o the 
 * model.
 * 
 * @author Semir, Dan & Milos
 */
@Stateless
public class Controller1 {
   
    @Inject
    PersonDAO persondao;
    @Inject
    RoleDAO roledao;
    @Inject
    CompetenceDAO competencedao;
    
    Person person;
    Availability availibility;
    List<CompetenceHolder> competenceHolder;

    /**
     * The Controllers constructor
     */
    public Controller1() {}

    /**
     * 
     * @param personDTO A DTO carrting all the data to create a Person Entity.
     */
    public void addPerson(PersonDTO personDTO) {
        Person person = new Person();
        
        person.setFirstname(personDTO.getName());
        person.setSurname(personDTO.getSurname());
        person.setUsername(personDTO.getUsername());
        person.setUserpassword(personDTO.getPassword());
        person.setEmail(personDTO.getEmail());
        person.setSsn(personDTO.getSsn());
        person.setPersonId((long) 1);
        Role role = roledao.findByID(3);
        
        person.setRoleId(role);
        System.out.println("Person to be added to the pu : " + person.toString());

        persondao.addPerson(person);
    }

    public void addCompetenceToDB(List<String> values) {
        
        for(int i = 0; i < values.size(); i++ ){
            Competence c = new Competence();
            c.setCompetenceName(values.get(i));
            competencedao.addCompetence(c);
        }        
    }
    
    public void persistAll(Person person, Availability availibility, List <CompetenceHolder> ch){
        
        //Persist Person
        
        //Get Person ID
        
        //Persist Availibility
        
        //Persist Competene
        
        //Get Competence ID 
        
        //Persist Competence Profile
        
        

        
    }

}
