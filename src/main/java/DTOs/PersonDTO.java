/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTOs;

/**
 *
 * @author Dan
 */
public class PersonDTO {
    
    private String newPName;
    private String newPSurname;
    private String newPSsn;
    private String newPEmail;
    private String newPUsername;
    private String newPPassword;
    
    /**
     * Constructor.
     */
    public PersonDTO(){}
    
    /**
     * Constructor which loads the DTO with all the necessary Data when it's 
     * initialized.
     * 
     * @param name      The person's name
     * @param surname   The Person's surnmae
     * @param ssn       The Person's Social security number
     * @param email     The person's email
     * @param username  The Person's chosen username
     * @param password  The person's chosen password
     */
    public PersonDTO(String name, String surname, String ssn, String email, 
            String username, String password){
    
        newPName = name;
        newPSurname = surname;
        newPSsn = ssn;
        newPEmail = email;
        newPUsername = username;
        newPPassword = password;
    }

    /**
     * Set's the person's Name
     * @param newPName The person's name
     */
    public void setName(String newPName) {
        this.newPName = newPName;
    }

    /**
     *  Set's the person's surname
     * @param newPSurname person's surname
     */
    public void setSurname(String newPSurname) {
        this.newPSurname = newPSurname;
    }

    /**
     *  Set's the person's social security number
     * 
     * @param newPSsn The peron's social security number
     */
    public void setSsn(String newPSsn) {
        this.newPSsn = newPSsn;
    }

    /**
     *  Set's the person's email
     * 
     * @param newPEmail The person's email
     */
    public void setEmail(String newPEmail) {
        this.newPEmail = newPEmail;
    }

    /**
     *  Set's the person's username
     * 
     * @param newPUsername The person's username
     */
    public void setPUsername(String newPUsername) {
        this.newPUsername = newPUsername;
    }

    /**
     * Set's the person's password
     * 
     * @param newPPassword The person's password
     */
    public void setPassword(String newPPassword) {
        this.newPPassword = newPPassword;
    }

    /**
     * Get's the person's name
     * 
     * @return The person's name
     */
    public String getName() {
        return newPName;
    }

    /**
     *  Get's the person's surname
     * 
     * @return The person's surname
     */
    public String getSurname() {
        return newPSurname;
    }

    /**
     * Get's the person's social security number
     * 
     * @return The person's social security number
     */
    public String getSsn() {
        return newPSsn;
    }

    /**
     * Get's the person's email
     * 
     * @return The person's email
     */
    public String getEmail() {
        return newPEmail;
    }

    /**
     * Get's the person's username
     * 
     * @return The person's username
     */
    public String getUsername() {
        return newPUsername;
    }

    /**
     * Get's the person's password
     * 
     * @return The person's password
     */
    public String getPassword() {
        return newPPassword;
    }
    
    
    
}
