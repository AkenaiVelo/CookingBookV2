
package com.cookbook.POJO;

import com.cookbook.ENGINE.EngineDanie;
import com.cookbook.ENGINE.EngineKonto;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class Komentarz implements Serializable {

    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_KOMENTARZ")
    private Integer idKomentarz;
    @Column(name = "DATA_WYSTAWIENIA")
    private Date dataWystawienia;
    @Column(name = "OPIS")
    private String opis;
    @ManyToOne(targetEntity = EngineKonto.class)
    @JoinColumn(name="AUTOR")
    private EngineKonto autor;
    @ManyToOne(targetEntity = EngineDanie.class)
    @JoinColumn(name="ID_DANIA")
    private EngineDanie idDania;


    public Komentarz() {
    }

    public Komentarz(Date dataWystawienia, String opis, EngineKonto autor) {
        this.dataWystawienia = dataWystawienia;
        this.opis = opis;
        this.autor = autor;
    }
    
     public Komentarz( Date dataWystawienia, String opis, EngineKonto autor, EngineDanie idDania) {
        this.dataWystawienia = dataWystawienia;
        this.opis = opis;
        this.autor = autor;
        this.idDania = idDania;
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

    public EngineKonto getAutor() {
        return autor;
    }

    public void setAutor(EngineKonto autor) {
        this.autor = autor;
    }

    public EngineDanie getIdDania() {
        return idDania;
    }

    public void setIdDania(EngineDanie idDania) {
        this.idDania = idDania;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKomentarz != null ? idKomentarz.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Komentarz)) {
            return false;
        }
        Komentarz other = (Komentarz) object;
        if (this.idKomentarz == null && other.idKomentarz != null ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cookbook.POJO.Komentarz[ idKomentarz=" + idKomentarz + " ]";
    }
    
}
