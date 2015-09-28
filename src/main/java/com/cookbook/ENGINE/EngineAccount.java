package com.cookbook.ENGINE;

import com.cookbook.DTO.AccountDTO;
import com.cookbook.POJO.Account;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "HIBER.ACCOUNT")
public class EngineAccount extends Account {

    public EngineAccount() {
    }

    public EngineAccount(String login, String password) {
        super(login, password);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        return !((!this.getLogin().equals(other.getLogin())) || (!this.getPassword().equals(other.getPassword())));
    }
    
    @Override
    public int hashCode()//hashcode po pierwszej literce loginu
    {
        return Character.getNumericValue(getLogin().charAt(0));
    }
    
    @Override
    public String toString()
    {
        return super.toString();
    }
}