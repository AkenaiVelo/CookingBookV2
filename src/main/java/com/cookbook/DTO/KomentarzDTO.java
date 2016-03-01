package com.cookbook.DTO;

import com.cookbook.ENGINE.EngineKomentarz;
import java.util.Date;

public class KomentarzDTO {
   
    private Integer idKomentarz;
    private Date dataWystawienia;
    private String opis;

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
    @Override
    public String toString()
    {
        return" komentarz("+dataWystawienia+"): "+opis;
    }
}