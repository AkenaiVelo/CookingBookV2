package com.cookbook.POJO;

import com.cookbook.ENGINE.EngineSkladnikiDania;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@MappedSuperclass
public class Skladniki implements Serializable{
    private static final long serialVersionUID = 12L;
    @Id
    @Column(name = "NAZWA")
    private String nazwa;
    @Column(name = "OPIS")
    private String opis;
    @Column(name = "ZDJECIE")
    private String zdjecie;
    @OneToMany( fetch = FetchType.EAGER, targetEntity = EngineSkladnikiDania.class,cascade = CascadeType.ALL)
    @JoinColumn(name="NAZWASKLADNIKA", referencedColumnName="NAZWA")
    private List<EngineSkladnikiDania> skladnikiDania;
    @Column(name = "JEDNOSTKA")
    private String jednostka;

    public Skladniki(String nazwa, String opis, String zdjecia,String jednostka) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.zdjecie = zdjecia;
        this.jednostka=jednostka;
    }

    public Skladniki() {
    }
    
    

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getZdjecie() {
        return zdjecie;
    }

    public void setZdjecie(String zdjecie) {
        this.zdjecie = zdjecie;
    }

    public List<EngineSkladnikiDania> getSkladnikiDania() {
        return skladnikiDania;
    }

    public void setSkladnikiDania(List<EngineSkladnikiDania> skladnikiDania) {
        this.skladnikiDania = skladnikiDania;
    }

    public String getJednostka() {
        return jednostka;
    }

    public void setJednostka(String jednostka) {
        this.jednostka = jednostka;
    }
    
    @Override
    public String toString() {
        return "Skladniki{" + "nazwa=" + nazwa + ", opis=" + opis + ", zdjecie=" + zdjecie + '}';
    }
   
}
