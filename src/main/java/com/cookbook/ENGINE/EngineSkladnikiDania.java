package com.cookbook.ENGINE;

import com.cookbook.POJO.SkladnikiDania;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "HIBER.SKLADNIKI_DANIA")
public class EngineSkladnikiDania extends SkladnikiDania{

    public EngineSkladnikiDania() {
        super();
    }

    public EngineSkladnikiDania(int idSkladnikiDania, EngineDanie idDania, EngineSkladniki nazwaSkladnika, int ilosc) {
        super(idSkladnikiDania, idDania, nazwaSkladnika, ilosc);
    }
    
}
