package com.cookbook.POJO;

import com.cookbook.ENGINE.EngineDanie;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class GaleriaDan implements Serializable{
    private static final long serialVersionUID = 41L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ZDJECIA")
    private int idZdjecia;
    @Column(name = "NUMER")
    private int numer;
    @Column(name = "NAZWA")
    private String nazwa;
    @Column(name = "ZDJECIE")
    private String zdjecie;
    @ManyToOne(targetEntity = EngineDanie.class)
    @JoinColumn(name="ID_DANIA")
    private EngineDanie idDania;

    public GaleriaDan() {
    }

    public GaleriaDan(int idZdjecia, int numer, String nazwa, String zdjecie, EngineDanie IdDania) {
        this.idZdjecia = idZdjecia;
        this.numer = numer;
        this.nazwa = nazwa;
        this.zdjecie = zdjecie;
        this.idDania = IdDania;
    }

    public int getIdZdjecia() {
        return idZdjecia;
    }

    public void setIdZdjecia(int idZdjecia) {
        this.idZdjecia = idZdjecia;
    }

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getZdjecie() {
        return zdjecie;
    }

    public void setZdjecie(String zdjecie) {
        this.zdjecie = zdjecie;
    }

    public EngineDanie getIdDania() {
        return idDania;
    }

    public void setIdDania(EngineDanie IdDania) {
        this.idDania = IdDania;
    }
     @Override
    public int hashCode()//hashcode po pierwszej literce loginu
    {
        return idZdjecia;
    }
    
    @Override
    public String toString()
    {
        return "Zdjecie "+nazwa;
    }
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof GaleriaDan)) {
            return false;
        }
        GaleriaDan other = (GaleriaDan) object;
        if (this.idZdjecia != other.idZdjecia ) {
            return false;
        }
        return true;
    }
}