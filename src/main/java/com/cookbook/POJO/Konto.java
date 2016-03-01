package com.cookbook.POJO;

import com.cookbook.ENGINE.EngineKomentarz;
import java.io.Serializable;
import java.util.ArrayList;
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
  
    public Konto() {
    }   
    
    public Konto(String login, String password)
    {
        this.login = login;
        this.haslo = password;
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

    public List<EngineKomentarz> getAddressList() {
        return komentarze;
    }

    public void setAddressList(List<EngineKomentarz> komentarze) {
        this.komentarze = komentarze;
    }

     @Override
    public String toString() {
        return "Login = " + this.getLogin() + " , haslo = " + this.getHaslo();
    }
   
}