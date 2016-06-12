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
        super();
    }

    public EngineKonto(String login, String haslo) {
        super(login, haslo);
    }

    public EngineKonto(String login, String haslo, String email, int poziom) {
        super(login, haslo, email, poziom);
    }
    
    

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EngineKonto)) {
            return false;
        }
        EngineKonto other = (EngineKonto) object;
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