package com.cookbook.ENGINE;

import com.cookbook.POJO.GaleriaDan;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "HIBER.GALERIA_DAN")
public class EngineGaleriaDan extends GaleriaDan {

    public EngineGaleriaDan() {
        super();
    }

    public EngineGaleriaDan(int idZdjecia, int numer, String nazwa, String zdjecie, EngineDanie idDania) {
        super(idZdjecia, numer, nazwa, zdjecie, idDania);
    }

    @Override
    public int hashCode()//hashcode po pierwszej literce loginu
    {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}