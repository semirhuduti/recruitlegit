/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DAO;

import java.util.List;
import model.Competence;
import model.CompetenceProfile;

/**
 *
 * @author Semir
 */
public interface CompetenceProfileDAOInterface {
    
    public void addCompetenceProfile(CompetenceProfile competencep);
    public void removeCompetenceProfile(CompetenceProfile competencep);
    public CompetenceProfile findByID(long id);
    public List<CompetenceProfile> findAll();
    public CompetenceProfile findByName(String name);
    
}
