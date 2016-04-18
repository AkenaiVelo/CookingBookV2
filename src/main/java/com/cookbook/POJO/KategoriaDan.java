package com.cookbook.POJO;

import com.cookbook.ENGINE.EngineDanie;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
@MappedSuperclass
public class KategoriaDan implements Serializable{
    private static final long serialVersionUID = 3L;
    @Id
    @Column(name = "NAZWA")
    private String nazwa;
    @Column(name = "OPIS")
    private String opis;
    @OneToMany( fetch = FetchType.EAGER, targetEntity = EngineDanie.class)
    @JoinColumn(name="Kategoria", referencedColumnName="Nazwa")
    private List<EngineDanie> dania;

    public KategoriaDan() {
    }

    public KategoriaDan(String Nazwa, String opis) {
        this.nazwa = Nazwa;
        this.opis = opis;
    }
    
    

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String Nazwa) {
        this.nazwa = Nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public List<EngineDanie> getDania() {
        return dania;
    }

    public void setDania(List<EngineDanie> Dania) {
        this.dania = Dania;
    }

    @Override
    public String toString() {
        return "KategoriaDan{" + "Nazwa=" + nazwa + ", opis=" + opis + ", Dania=" + dania + '}';
    }
    
}
