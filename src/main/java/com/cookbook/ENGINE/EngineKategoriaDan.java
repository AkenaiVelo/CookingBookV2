
package com.cookbook.ENGINE;

import com.cookbook.POJO.KategoriaDan;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "HIBER.KATEGORIA_DAN")
public class EngineKategoriaDan extends KategoriaDan{

    public EngineKategoriaDan() {
        super();
    }

    public EngineKategoriaDan(String Nazwa, String opis) {
        super(Nazwa, opis);
    }

    @Override
    public String toString() {
        return "EngineKategoriaDan{" +super.toString()+ '}';
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EngineKategoriaDan)) {
            return false;
        }
        EngineKategoriaDan other = (EngineKategoriaDan) object;
        return !((!this.getNazwa().equals(other.getNazwa()))); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
