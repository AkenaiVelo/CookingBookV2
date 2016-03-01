package com.cookbook.ENGINE;

import com.cookbook.POJO.Konto;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "HIBER.KONTO")
public class EngineKonto extends Konto {

    public EngineKonto() {
    }

    public EngineKonto(String login, String haslo) {
        super(login, haslo);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Konto)) {
            return false;
        }
        Konto other = (Konto) object;
        return !((!this.getLogin().equals(other.getLogin())) || (!this.getHaslo().equals(other.getHaslo())));
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