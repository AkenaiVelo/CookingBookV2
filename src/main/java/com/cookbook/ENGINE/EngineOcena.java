package com.cookbook.ENGINE;

import com.cookbook.POJO.Ocena;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "HIBER.OCENA")
public class EngineOcena extends Ocena{

    public EngineOcena() {
    }

    public EngineOcena(EngineKonto login, EngineDanie idDania, int ocena) {
        super(login, idDania, ocena);
    }

    @Override
    public String toString() {
        return "EngineOcena{" +super.toString()+ '}';
    }
    
}
