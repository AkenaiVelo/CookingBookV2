
package com.cookbook.DTO;

public class RankingDTO implements Comparable<RankingDTO>{
    
    private String nazwaDania;
    private int suma;
    private int pozytywne;
    private int negatywne;

    public RankingDTO(String nazwaDania, int suma, int pozytywne, int negatywne) {
        this.nazwaDania = nazwaDania;
        this.suma = suma;
        this.pozytywne = pozytywne;
        this.negatywne = negatywne;
    }

    public String getNazwaDania() {
        return nazwaDania;
    }

    public void setNazwaDania(String nazwaDania) {
        this.nazwaDania = nazwaDania;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public int getPozytywne() {
        return pozytywne;
    }

    public void setPozytywne(int pozytywne) {
        this.pozytywne = pozytywne;
    }

    public int getNegatywne() {
        return negatywne;
    }

    public void setNegatywne(int negatywne) {
        this.negatywne = negatywne;
    }

    @Override
    public String toString() {
        return "RankingDTO{" + "nazwaDania=" + nazwaDania + ", suma=" + suma + ", pozytywne=" + pozytywne + ", negatywne=" + negatywne + '}';
    }
    
    

    @Override
    public int compareTo(RankingDTO o) {
        if(suma==o.suma)
        {
            return 0;
        }
        if(suma>o.suma)
        {
            return -1;
        }
        return 1;
    }
    
}
