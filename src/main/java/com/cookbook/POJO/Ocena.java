package com.cookbook.POJO;

import com.cookbook.ENGINE.EngineDanie;
import com.cookbook.ENGINE.EngineKonto;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Ocena implements Serializable{
    private static final long serialVersionUID = 7L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDOCENY")
    private int idOceny;
    
    @ManyToOne(targetEntity = EngineKonto.class)
    @JoinColumn(name="login")
    private EngineKonto login;
    
    @ManyToOne(targetEntity = EngineDanie.class)
    @JoinColumn(name = "IDDANIA")
    private EngineDanie idDania;
    
    @Column(name = "OCENA")
    private int ocena;

    public Ocena() {
    }

    public Ocena(EngineKonto login, EngineDanie idDania, int ocena) {
        this.login = login;
        this.idDania = idDania;
        this.ocena = ocena;
    }

    public int getIdOceny() {
        return idOceny;
    }

    public void setIdOceny(int idOceny) {
        this.idOceny = idOceny;
    }

    public EngineKonto getLogin() {
        return login;
    }

    public void setLogin(EngineKonto login) {
        this.login = login;
    }

    public EngineDanie getIdDania() {
        return idDania;
    }

    public void setIdDania(EngineDanie idDania) {
        this.idDania = idDania;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idOceny;
        hash = 59 * hash + this.ocena;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ocena other = (Ocena) obj;
        if (this.idOceny != other.idOceny) {
            return false;
        }
        if (this.ocena != other.ocena) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        return Objects.equals(this.idDania, other.idDania);
    }

    @Override
    public String toString() {
        return "Ocena{" + "idOceny=" + idOceny + ", login=" + login + ", idDania=" + idDania + ", ocena=" + ocena + '}';
    }
 
}
