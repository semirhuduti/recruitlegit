/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DTOs.PersonDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import model.Availability;
import model.Competence;
import model.CompetenceProfile;
import model.DAO.AvailabilityDAO;
import model.DAO.CompetenceDAO;
import model.DAO.CompetenceProfileDAO;
import model.DAO.PersonDAO;
import model.DAO.RoleDAO;
import model.Person;
import util.holder.CompetenceHolder;



/**
 * Controller class which handles all calls from the RegisterBean class o the 
 * model.
 * 
 * @author Semir, Dan & Milos
 */
@Stateless
public class Controller {
   
    @Inject
    PersonDAO persondao;
    @Inject
    RoleDAO roledao;
    @Inject
    CompetenceDAO competencedao;
    @Inject
    AvailabilityDAO availabilitydto;
    @Inject
    CompetenceProfileDAO cpdao;
    
    PersonDTO personDTO;
    Availability availibility;
    List<CompetenceHolder> competenceHolder;

    public PersonDTO getPerson() {
        return personDTO;
    }

    public void setPerson(PersonDTO person) {
        this.personDTO = person;
    }

    public Availability getAvailibility() {
        return availibility;
    }

    public void setAvailibility(Availability availibility) {
        this.availibility = availibility;
    }

    public List<CompetenceHolder> getCompetenceHolder() {
        return competenceHolder;
    }

    public void setCompetenceHolder(List<CompetenceHolder> competenceHolder) {
        this.competenceHolder = competenceHolder;
    }

    /**
     * The Controllers constructor
     */
    public Controller() {}

}
