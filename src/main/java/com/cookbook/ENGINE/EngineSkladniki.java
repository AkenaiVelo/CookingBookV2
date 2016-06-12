package com.cookbook.ENGINE;

import com.cookbook.POJO.Skladniki;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "HIBER.SKLADNIKI")
public class EngineSkladniki extends Skladniki{

    public EngineSkladniki(String nazwa, String opis, String zdjecia,String jednostka) {
        super(nazwa, opis, zdjecia,jednostka);
    }

    public EngineSkladniki() {
        super();
    }

    @Override
    public String toString() {
        return super.toString(); 
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EngineSkladniki)) {
            return false;
        }
        EngineSkladniki other = (EngineSkladniki) object;
        return !((!this.getNazwa().equals(other.getNazwa())));
    }

    @Override
    public int hashCode() {
        return Character.getNumericValue(getNazwa().charAt(0));
    }
}