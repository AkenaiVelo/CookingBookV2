package com.cookbook.POJO;

import com.cookbook.ENGINE.EngineDanie;
import com.cookbook.ENGINE.EngineKomentarz;
import com.cookbook.ENGINE.EngineOcena;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@MappedSuperclass
public class Konto implements Serializable {

    private static final long serialVersionUID = 3L;
    @Id
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "HASLO")
    private String haslo;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "POZIOM")
    private int poziom;
    @OneToMany( fetch = FetchType.EAGER, targetEntity = EngineKomentarz.class)
    @JoinColumn(name="AUTOR", referencedColumnName="LOGIN")
    private List<EngineKomentarz> komentarze;
    @OneToMany( fetch = FetchType.EAGER, targetEntity = EngineDanie.class)
    @JoinColumn(name="AUTOR", referencedColumnName="LOGIN")
    private List<EngineDanie> dania;
    @OneToMany( fetch = FetchType.EAGER, targetEntity = EngineOcena.class)
    @JoinColumn(name="login", referencedColumnName="login")
    private List<EngineOcena> oceny;
  
    public Konto() {
    }   
    
    public Konto(String login, String password)
    {
        this.login = login;
        this.haslo = password;
    }

    public Konto(String login, String haslo, String email, int poziom) {
        this.login = login;
        this.haslo = haslo;
        this.email = email;
        this.poziom = poziom;
    }
    
    
    
    public String getLogin() {
        return login;
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

    public List<EngineKomentarz> getKomentarze() {
        return komentarze;
    }

    public void setKomentarze(List<EngineKomentarz> komentarze) {
        this.komentarze = komentarze;
    }

    public List<EngineDanie> getDania() {
        return dania;
    }

    public void setDania(List<EngineDanie> dania) {
        this.dania = dania;
    }

    public List<EngineOcena> getOceny() {
        return oceny;
    }

    public void setOceny(List<EngineOcena> oceny) {
        this.oceny = oceny;
    }

     @Override
    public String toString() {
        return "Login = " + this.getLogin() + " , haslo = " + this.getHaslo();
    }
   
}
