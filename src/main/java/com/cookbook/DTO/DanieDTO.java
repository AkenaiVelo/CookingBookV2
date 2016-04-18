package com.cookbook.DTO;

import com.cookbook.ENGINE.EngineDanie;
import java.util.Date;

public class DanieDTO {
    private int idDania;
    private String nazwa;
    private String opis;
    private Date dataDodania;
    private String film;
    private String kategoria;

    public DanieDTO() {
    }

    public DanieDTO(int idDania, String nazwa, String opis, Date dataDodania, String film,String kategoria) {
        this.idDania = idDania;
        this.nazwa = nazwa;
        this.opis = opis;
        this.dataDodania = dataDodania;
        this.film = film;
        this.kategoria=kategoria;
    }
    
    public DanieDTO(EngineDanie e)
    {
        idDania = e.getIdDania();
        nazwa = e.getNazwa();
        opis = e.getOpis();
        dataDodania = e.getDataDodania();
        film = e.getFilm();
        kategoria=e.getKategoria().getNazwa();
    }

    public int getIdDania() {
        return idDania;
    }

    public void setIdDania(int idDania) {
        this.idDania = idDania;
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

    public Date getDataDodania() {
        return dataDodania;
    }

    public void setDataDodania(Date dataDodania) {
        this.dataDodania = dataDodania;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }
    
    
    @Override
    public String toString()
    {
        return "Danie : "+nazwa+" z kategori: "+kategoria;
    }
}
