/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.inject.Inject;
import javax.inject.Named;
import model.Competence;
import model.DAO.AvailabilityDAO;
import model.DAO.CompetenceDAO;

/**
 *
 * @author Semir
 */
@Named("cbean")
@SessionScoped
public class CompetenceBean implements Serializable, ActionListener {

    @EJB
    private Controller controller;
    @Inject
    CompetenceDAO competencedao;
    
    private List<CompetenceHolder> competenceList = new ArrayList<>(); // getter+setter
     
    public List<CompetenceHolder> getCompetenceList() {
        return competenceList;
    }

    public void setCompetenceList(List<CompetenceHolder> addressList) {
        this.competenceList = addressList;
    }

    public void addCompetence() {
        competenceList.add(new CompetenceHolder());
    }
    
    public void addCompetenceToDB(){
        controller.setCompetenceHolder(competenceList);
    }

    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        addCompetenceToDB();
    }
    
    public void persistAll(){
        controller.persistAll();
    }
        
    public class CompetenceHolder{
        String competenceName;
        BigDecimal yoe;

        public String getCompetenceName() {
            return competenceName;
        }

        public void setCompetenceName(String competenceName) {
            this.competenceName = competenceName;
        }

        public BigDecimal getYoe() {
            return yoe;
        }

        public void setYoe(BigDecimal yoe) {
            this.yoe = yoe;
        }
        
    }

}
