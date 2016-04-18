package com.cookbook.DTO;

import com.cookbook.ENGINE.EngineSkladniki;

public class SkladnikiDTO {

    private String nazwa;
    private String opis;
    private String zdjecie;
    private String jednostka;

    public SkladnikiDTO() {
    }

    public SkladnikiDTO(EngineSkladniki e) {
        this.nazwa = e.getNazwa();
        this.opis = e.getOpis();
        this.zdjecie = e.getZdjecie();
        this.jednostka = e.getJednostka();
    }

    public SkladnikiDTO(String nazwa, String opis, String zdjecie, String jednostka) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.zdjecie = zdjecie;
        this.jednostka = jednostka;
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

    public String getJednostka() {
        return jednostka;
    }

    public void setJednostka(String jednostka) {
        this.jednostka = jednostka;
    }

    @Override
    public String toString() {
        return "SkladnikDTO{" + "nazwa=" + nazwa + ", opis=" + opis + ", zdjecie=" + zdjecie + ", jednostka=" + jednostka + '}';
    }

}
