package com.cookbook.DTO;

import com.cookbook.ENGINE.EngineOcena;

public class OcenaDTO {
     private int idOceny;
     private String login;
     private String idDania;
     private int ocena;

    public OcenaDTO(String login, String idDania, int ocena) {
        this.login = login;
        this.idDania = idDania;
        this.ocena = ocena;
    }

    public OcenaDTO(int idOceny, String login, String idDania, int ocena) {
        this.idOceny = idOceny;
        this.login = login;
        this.idDania = idDania;
        this.ocena = ocena;
    }

    public OcenaDTO(EngineOcena e) {
        this.idOceny = e.getIdOceny();
        this.login = e.getLogin().getLogin();
        this.idDania = e.getIdDania().getNazwa();
        this.ocena = e.getOcena();
    }
    

    public int getIdOceny() {
        return idOceny;
    }

    public void setIdOceny(int idOceny) {
        this.idOceny = idOceny;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getIdDania() {
        return idDania;
    }

    public void setIdDania(String idDania) {
        this.idDania = idDania;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }
     
}
