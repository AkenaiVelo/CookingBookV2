package com.cookbook.ENGINE;

import com.cookbook.POJO.Danie;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "HIBER.DANIA")
public class EngineDanie extends Danie{

    public EngineDanie() {
        super();
    }

    public EngineDanie(int idDania, String nazwa, String opis, Date dataDodania, EngineKonto autor, String film) {
        super(idDania, nazwa, opis, dataDodania, autor, film);
    }
    
    @Override
    public int hashCode()//hashcode po pierwszej literce loginu
    {
        return super.hashCode();
    }
    
    @Override
    public String toString()
    {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) { 
        return super.equals(obj);
    }
}