package com.cookbook.ENGINE;

import com.cookbook.DTO.PersonDTO;
import com.cookbook.POJO.Persons;
import java.util.List;
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

    public EnginePersons(PersonDTO p) {
        super(p);
    }

    public EnginePersons(int person_id, String firstname, String Surname, List<EngineAddress> adresy) {
        super(firstname, Surname, adresy);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getPersonId() != null ? this.getPersonId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Persons)) {
            return false;
        }
        Persons other = (Persons) object;
        if ((this.getPersonId() == null && other.getPersonId() != null) || (this.getPersonId() != null && !this.getPersonId().equals(other.getPersonId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}