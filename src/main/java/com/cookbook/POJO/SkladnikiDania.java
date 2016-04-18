package com.cookbook.POJO;

import com.cookbook.ENGINE.EngineDanie;
import com.cookbook.ENGINE.EngineSkladniki;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class SkladnikiDania implements Serializable{
    private static final long serialVersionUID = 13L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDSKLADNIKIDANIA")
    private int idSkladnikiDania;
    @ManyToOne(targetEntity = EngineDanie.class)
    @JoinColumn(name = "IDDANIA")
    private EngineDanie idDania;
    @ManyToOne(targetEntity = EngineSkladniki.class)
    @JoinColumn(name = "NAZWASKLADNIKA")
    private EngineSkladniki nazwaSkladnika;
    @Column(name = "ILOSC")
    private int ilosc;

    public SkladnikiDania() {
    }

    public SkladnikiDania(int idSkladnikiDania, EngineDanie idDania, EngineSkladniki nazwaSkladnika, int ilosc) {
        this.idSkladnikiDania = idSkladnikiDania;
        this.idDania = idDania;
        this.nazwaSkladnika = nazwaSkladnika;
        this.ilosc = ilosc;
    }

    public int getIdSkladnikiDania() {
        return idSkladnikiDania;
    }

    public void setIdSkladnikiDania(int idSkladnikiDania) {
        this.idSkladnikiDania = idSkladnikiDania;
    }

    public EngineDanie getIdDania() {
        return idDania;
    }

    public void setIdDania(EngineDanie idDania) {
        this.idDania = idDania;
    }

    public EngineSkladniki getNazwaSkladnika() {
        return nazwaSkladnika;
    }

    public void setNazwaSkladnika(EngineSkladniki nazwaSkladnika) {
        this.nazwaSkladnika = nazwaSkladnika;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    @Override
    public String toString() {
        return "SkladnikiDania{" + "idSkladnikiDania=" + idSkladnikiDania + ", Dania=" + idDania.getNazwa() + ", nazwaSkladnika=" + nazwaSkladnika.getNazwa() + ", ilosc=" + ilosc + '}';
    }
    
     @Override
    public int hashCode()//hashcode po pierwszej literce loginu
    {
        return idSkladnikiDania;
    }
     @Override
    public boolean equals(Object object) {
        if (!(object instanceof SkladnikiDania)) {
            return false;
        }
        SkladnikiDania other = (SkladnikiDania) object;
        if (this.idSkladnikiDania != other.idSkladnikiDania ) {
            return false;
        }
        return true;
    }

}
