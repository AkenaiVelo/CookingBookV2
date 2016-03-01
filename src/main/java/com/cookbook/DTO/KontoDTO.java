package com.cookbook.DTO;

import com.cookbook.ENGINE.EngineKonto;
import com.cookbook.POJO.Komentarz;
import java.util.ArrayList;

public class KontoDTO {
   
    private String login;
    private String haslo;
    private String email;
    private int poziom;

    public KontoDTO(String login, String haslo, String email, int poziom) {
        this.login = login;
        this.haslo = haslo;
        this.email = email;
        this.poziom = poziom;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoziom() {
        return poziom;
    }

    public void setPoziom(int poziom) {
        this.poziom = poziom;
    }
    
    
    public KontoDTO(EngineKonto konto)
    {
        login=konto.getLogin();
        haslo=konto.getHaslo();
        email=konto.getEmail();
        poziom=konto.getPoziom();
    }
    @Override
    public String toString() {
        return "Login= " + login + " Haslo= " + haslo;
    }
}