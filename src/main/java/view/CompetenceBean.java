/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;

import javax.inject.Named;
import model.Competence;

/**
 *
 * @author Semir
 */
@Named("cbean")
@ViewScoped
public class CompetenceBean implements Serializable {

    @EJB
    private Controller controller;
    
    private List<String> addressList = new ArrayList<String>(); // getter+setter

    public List<String> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<String> addressList) {
        this.addressList = addressList;
    }

    public void addAddress() {
        addressList.add("");
    }

    public void persistAddresses() {
        System.out.println("From competence bean to db:" + addressList.toString());
    }

}
