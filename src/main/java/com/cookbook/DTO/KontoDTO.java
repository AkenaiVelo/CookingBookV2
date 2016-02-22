package com.cookbook.DTO;

import com.cookbook.ENGINE.EngineKonto;

public class KontoDTO {
   
    private String login;
    private String haslo;

    public KontoDTO(String login, String haslo) {
        this.login = login;
        this.haslo = haslo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
    
    public KontoDTO(EngineKonto account)
    {
        login=account.getLogin();
        haslo=account.getHaslo();
    }
    public String toString() {
        return "Login= " + login + " Haslo= " + haslo;
    }
}