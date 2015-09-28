package com.cookbook.POJO;

import com.cookbook.DTO.AccountDTO;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Account implements Serializable {

    private static final long serialVersionUID = 3L;
    @Id
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PASSWORD")
    private String password;
  
    public Account() {
    }   
    
    public Account(String login, String password)
    {
        this.login = login;
        this.password = password;
    }
    
    public String getLogin() {
        return login;
    }  

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
     @Override
    public String toString() {
        return "Login = " + this.getLogin() + " , password = " + this.getPassword();
    }
   
}
