package com.cookbook.POJO;

import com.cookbook.DTO.PersonDTO;
import com.cookbook.DTO.AccountDTO;
import com.cookbook.ENGINE.EngineAddress;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@MappedSuperclass
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
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
    
    public Account(AccountDTO a) {
       login = a.getLogin();
       password = a.getPassword();
    }
    

  /*  public Account(String firstname, String surname, List<EngineAddress> addressList) {
        this.firstname = firstname;
        this.surname = surname;
        this.addressList = addressList;
    }
*/

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
