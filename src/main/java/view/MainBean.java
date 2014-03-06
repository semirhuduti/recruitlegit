/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Availability;
import model.Competence;
import model.CompetenceProfile;
import model.DAO.CompetenceDAO;
import model.DAO.RoleDAO;
import model.Person;
import model.Role;
import util.holder.CompetenceHolder;

@Named("mbean")
@ConversationScoped
public class MainBean implements Serializable {

    /**
     * Injected Objects
     */
    @EJB
    Controller controller;

    @Inject
    RoleDAO roledao;

    @Inject
    CompetenceDAO competencedao;

    /**
     * Entitys
     */
    Person person;
    Availability availability;
    Competence competence;
    CompetenceProfile competenceProfile;
    Role role;

    /**
     * Field values
     */
    private Date datefrom;
    private Date dateto;

    String email;
    String SSN;
    String password;
    String username;
    String firstName;
    String surName;
    
    Competence chosenCompetence;

    public Competence getChosenCompetence() {
        return chosenCompetence;
    }

    public void setChosenCompetence(Competence chosenCompetence) {
        this.chosenCompetence = chosenCompetence;
    }

    private Competence[] boxCompetenceList;

    public Competence[] getBoxCompetenceListValues() {
        
        List<Competence> c = competencedao.findAll();
        
        boxCompetenceList = new Competence[c.size()];
        
        for(int i = 0; i < c.size(); i++){
            boxCompetenceList[i] = c.get(i);
        }

        return boxCompetenceList;

    }

    private List<CompetenceHolder> competenceList = new ArrayList<>();

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surname) {
        this.surName = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Person getPerson() {

        role = roledao.findByID(3);

        person = new Person();
        person.setEmail(email);
        person.setFirstname(firstName);
        person.setSsn(SSN);
        person.setSurname(surName);
        person.setUsername(username);
        person.setUserpassword(password);
        person.setRoleId(role);

        return person;
    }

    public Date getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(Date datefrom) {
        this.datefrom = datefrom;
    }

    public Date getDateto() {
        return dateto;
    }

    public void setDateto(Date dateto) {
        this.dateto = dateto;
    }

    public List<CompetenceHolder> getCompetenceList() {
        return competenceList;
    }

    public void setCompetenceList(List<CompetenceHolder> addressList) {
        this.competenceList = addressList;
    }

    public void addCompetence() {
        competenceList.add(new CompetenceHolder());
    }

    public List<CompetenceHolder> getCompetenceHolder() {
        return competenceList;
    }

    public Availability getAvailibility() {
        availability = new Availability();
        availability.setFromDate(datefrom);
        availability.setToDate(dateto);
        availability.setPersonId(null);
        return availability;
    }

}
