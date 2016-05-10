package com.cookbook.POJO;

import com.cookbook.ENGINE.EngineKategoriaDan;
import com.cookbook.ENGINE.EngineKonto;
import com.cookbook.ENGINE.EngineSkladnikiDania;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
@MappedSuperclass
public class Danie implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DANIA")
    private int idDania;
    @Column(name = "NAZWA")
    private String nazwa;
    @Column(name = "OPIS")
    private String opis;
    @Column(name = "DATA_DODANIA")
    private Date dataDodania;
    @ManyToOne(targetEntity = EngineKonto.class)
    @JoinColumn(name="AUTOR")
    private EngineKonto autor;
    @ManyToOne(targetEntity = EngineKategoriaDan.class)
    @JoinColumn(name="Kategoria")
    private EngineKategoriaDan kategoria;
    @Column(name = "FILM")
    private String film;
    @OneToMany( fetch = FetchType.EAGER, targetEntity = EngineSkladnikiDania.class)
    @JoinColumn(name="IDDANIA", referencedColumnName="ID_DANIA")
    private List<EngineSkladnikiDania> skladnikiDania;

    public Danie() {
    }

    public Danie(int idDania, String nazwa, String opis, Date dataDodania, EngineKonto autor, String film) {
        this.idDania = idDania;
        this.nazwa = nazwa;
        this.opis = opis;
        this.dataDodania = dataDodania;
        this.autor = autor;
        this.film = film;
    }
    
    
    public int getIdDania() {
        return idDania;
    }

    public void setIdDania(int idDania) {
        this.idDania = idDania;
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

    public Date getDataDodania() {
        return dataDodania;
    }

    public void setDataDodania(Date dataDodania) {
        this.dataDodania = dataDodania;
    }

    public EngineKonto getAutor() {
        return autor;
    }

    public void setAutor(EngineKonto autor) {
        this.autor = autor;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public EngineKategoriaDan getKategoria() {
        return kategoria;
    }

    public void setKategoria(EngineKategoriaDan kategoria) {
        this.kategoria = kategoria;
    }

    public List<EngineSkladnikiDania> getSkladnikiDania() {
        return skladnikiDania;
    }

    public void setSkladnikiDania(List<EngineSkladnikiDania> skladnikiDania) {
        this.skladnikiDania = skladnikiDania;
    }
    
    
    
     @Override
    public int hashCode()//hashcode po pierwszej literce loginu
    {
        return idDania;
    }
    
    @Override
    public String toString()
    {
        return "Danie "+nazwa;
    }
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Danie)) {
            return false;
        }
        Danie other = (Danie) object;
        if (this.idDania != other.idDania ) {
            return false;
        }
        return true;
    }
}
