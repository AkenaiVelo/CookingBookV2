package com.cookbook.ENGINE;

import com.cookbook.POJO.Komentarz;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "HIBER.KOMENTARZ")
public class EngineKomentarz extends Komentarz {

    public EngineKomentarz() {
    }

    public EngineKomentarz(Date dataWystawienia, String opis, EngineKonto autor) {
        super(dataWystawienia, opis, autor);
    }


    @Override
    public int hashCode()//hashcode po pierwszej literce loginu
    {
        return getIdKomentarz();
    }
    
    @Override
    public String toString()
    {
        return super.toString();
    }
}