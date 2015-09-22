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

    public EngineAccount(AccountDTO e) {
        super(e);
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.getLogin() == null && other.getLogin() != null) || (this.getLogin() != null && !this.getLogin().equals(other.getLogin()))) {
            return false;
        }
        return true;
    }

    
}