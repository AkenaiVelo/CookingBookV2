package com.cookbook.DTO;

import com.cookbook.ENGINE.EngineGaleriaDan;

public class GaleriaDanDTO {
    
    private int idZdjecia;
    private int numer;
    private String nazwa;
    private String zdjecie;

    public GaleriaDanDTO() {
    }

    public GaleriaDanDTO(int idZdjecia, int numer, String nazwa, String zdjecie) {
        this.idZdjecia = idZdjecia;
        this.numer = numer;
        this.nazwa = nazwa;
        this.zdjecie = zdjecie;
    }
    
    public GaleriaDanDTO(EngineGaleriaDan e) {
        idZdjecia=e.getIdZdjecia();
        numer=e.getNumer();
        nazwa=e.getNazwa();
        zdjecie=e.getZdjecie();
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

    @Override
    public String toString() {
        return "Zdjecie{" + "idZdjecia=" + idZdjecia + ", numer=" + numer + ", nazwa=" + nazwa + ", zdjecie=" + zdjecie + '}';
    }
    
    
}