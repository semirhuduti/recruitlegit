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
    
    public PersonDTO(){}
    
    public PersonDTO(String name, String surname, String ssn, String email, 
            String username, String password){
    
        newPName = name;
        newPSurname = surname;
        newPSsn = ssn;
        newPEmail = email;
        newPUsername = username;
        newPPassword = password;
    }

    public void setName(String newPName) {
        this.newPName = newPName;
    }

    public void setSurname(String newPSurname) {
        this.newPSurname = newPSurname;
    }

    public void setSsn(String newPSsn) {
        this.newPSsn = newPSsn;
    }

    public void setEmail(String newPEmail) {
        this.newPEmail = newPEmail;
    }

    public void setPUsername(String newPUsername) {
        this.newPUsername = newPUsername;
    }

    public void setPassword(String newPPassword) {
        this.newPPassword = newPPassword;
    }

    public String getName() {
        return newPName;
    }

    public String getSurname() {
        return newPSurname;
    }

    public String getSsn() {
        return newPSsn;
    }

    public String getEmail() {
        return newPEmail;
    }

    public String getUsername() {
        return newPUsername;
    }

    public String getPassword() {
        return newPPassword;
    }
    
    
    
}
