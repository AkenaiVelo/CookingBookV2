package com.cookbook.DTO;

import com.cookbook.ENGINE.EngineKomentarz;
import java.util.Date;

public class KomentarzDTO {
   
    private Integer idKomentarz;
    private Date dataWystawienia;
    private String opis;
    private String autor;
    private String danie;

    public KomentarzDTO() {
    }

    public KomentarzDTO(Date dataWystawienia, String opis) {
        this.dataWystawienia = dataWystawienia;
        this.opis = opis;
    }

    public KomentarzDTO(EngineKomentarz e) {
        this.idKomentarz = e.getIdKomentarz();
        this.dataWystawienia = e.getDataWystawienia();
        this.opis = e.getOpis();
    }

    public KomentarzDTO(Integer idKomentarz, Date dataWystawienia, String opis, String autor) {
        this.idKomentarz = idKomentarz;
        this.dataWystawienia = dataWystawienia;
        this.opis = opis;
        this.autor = autor;
    }
    
    public KomentarzDTO(EngineKomentarz e,String autor,String danie) {
        this.idKomentarz = e.getIdKomentarz();
        this.dataWystawienia = e.getDataWystawienia();
        this.opis = e.getOpis();
        this.autor=autor;
        this.danie=danie;
    }
    
    public Integer getIdKomentarz() {
        return idKomentarz;
    }

    public void setIdKomentarz(Integer idKomentarz) {
        this.idKomentarz = idKomentarz;
    }

    public Date getDataWystawienia() {
        return dataWystawienia;
    }

    public void setDataWystawienia(Date dataWystawienia) {
        this.dataWystawienia = dataWystawienia;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDanie() {
        return danie;
    }

    public void setDanie(String danie) {
        this.danie = danie;
    }
    
    
    @Override
    public String toString()
    {
        return" komentarz("+dataWystawienia+"): "+opis;
    }
}