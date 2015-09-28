package com.cookbook.ENGINE;

import com.cookbook.DTO.PersonDTO;
import com.cookbook.POJO.Persons;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "HIBER.PERSONS")
public class EnginePersons extends Persons {

    public EnginePersons() {
    }

    public EnginePersons(int person_id, String firstname, String Surname, List<EngineAddress> adresy) {
        super(firstname, Surname, adresy);
    }

    @Override
    public int hashCode() {
        return Character.getNumericValue(getSurname().charAt(0));
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Persons)) {
            return false;
        }
        Persons other = (Persons) object;
        return !((!Objects.equals(this.getPersonId(), other.getPersonId())) 
                || (!this.getFirstname().equals(other.getFirstname()))
                || (!this.getSurname().equals(other.getSurname())));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}