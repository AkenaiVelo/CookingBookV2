package com.cookbook.Service;

import com.cookbook.DAO.DanieDAO;
import com.cookbook.DAO.OcenaDAO;
import com.cookbook.DTO.OcenaDTO;
import com.cookbook.DTO.RankingDTO;
import com.cookbook.ENGINE.EngineDanie;
import com.cookbook.ENGINE.EngineOcena;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OcenaService {
    @Autowired
    private OcenaDAO ocena_dao;
    @Autowired
    private DanieDAO danieDao;
    
     public ArrayList<OcenaDTO> getUsersList() {
        ArrayList<OcenaDTO> result = new ArrayList<>();
        for (EngineOcena e : ocena_dao.findAllOceny()) {
            result.add(new OcenaDTO(e));
        }
        return result;
    }
     
     public boolean czyOceniona(String login,String nazwa)
     {
         int i=ocena_dao.iloscOcen(login, nazwa);
        return i != 0;
     }
     
     public void addOcena(String login,String nazwa,int ocena)
     {
         ocena_dao.addOcena(login, nazwa, ocena);
     }
     
     public ArrayList<RankingDTO> ranking()
     {
         ArrayList<RankingDTO> wynik=new ArrayList<>();
         int suma,pozytyw,negatyw;
         List<EngineDanie> dania=danieDao.findAllDania();
         for(EngineDanie e:dania)
         {
             suma=ocena_dao.sumaOcenDania(e.getNazwa());
             pozytyw=ocena_dao.sumaOcenpozytywnychDania(e.getNazwa());
             negatyw=ocena_dao.sumaOcenNegatywnychDania(e.getNazwa());
             wynik.add(new RankingDTO(e.getNazwa(), suma, pozytyw, negatyw));
         }
         Collections.sort(wynik);
         return wynik;
     }
}
