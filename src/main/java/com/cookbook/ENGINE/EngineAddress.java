package com.cookbook.ENGINE;

import com.cookbook.POJO.Address;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "HIBER.ADDRESS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class EngineAddress extends Address {

    public EngineAddress() {
    }

    public EngineAddress(String city, String zipcode, EnginePersons person) {
        super(city, zipcode, person);
    }

    @Override
    public int hashCode() {
        return getPersonId().getPersonId();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.getAddressId() != other.getAddressId())
                || (!this.getCity().equals(other.getCity()))
                || (!this.getZipcode().equals(other.getZipcode()))
                || (this.getPersonId().getPersonId() != other.getPersonId().getPersonId())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
