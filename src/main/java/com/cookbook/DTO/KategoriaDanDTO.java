
package com.cookbook.DTO;

import com.cookbook.ENGINE.EngineKategoriaDan;

public class KategoriaDanDTO {
     private String nazwa;
    private String opis;

    public KategoriaDanDTO() {
    }

    public KategoriaDanDTO(String nazwa, String opis) {
        this.nazwa = nazwa;
        this.opis = opis;
    }
    
    public KategoriaDanDTO(EngineKategoriaDan e)
    {
        nazwa=e.getNazwa();
        opis=e.getOpis();
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

    @Override
    public String toString() {
        return "KategoriaDanDTO{" + "nazwa=" + nazwa + ", opis=" + opis + '}';
    }
    
    
}
