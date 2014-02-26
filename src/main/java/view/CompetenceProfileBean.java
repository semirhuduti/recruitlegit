/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.New;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;
import model.Person;

/**
 *
 * @author Semir
 */
@Named("competenceProfileBean")
@SessionScoped
public class CompetenceProfileBean implements Serializable {
    
    
   @Inject
   CompetenceBean cb;
   
}
