package com.cookbook.Service;

import com.cookbook.DAO.GaleriaDanDAO;
import com.cookbook.DTO.GaleriaDanDTO;
import com.cookbook.ENGINE.EngineGaleriaDan;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GaleriaDanService {
    @Autowired
    GaleriaDanDAO galeria_dao;

    public GaleriaDanService() {
    }
    
    public ArrayList<GaleriaDanDTO> galeriaDania(int idDania) {
        ArrayList<GaleriaDanDTO> result = new ArrayList<>();
        for (EngineGaleriaDan e : galeria_dao.ZdjeciaDania(idDania)) {
            result.add(new GaleriaDanDTO(e));
        }
        return result;
    }
    
     public ArrayList<GaleriaDanDTO> galeriaDaniaByName(String name) {
        ArrayList<GaleriaDanDTO> result = new ArrayList<>();
        for (EngineGaleriaDan e : galeria_dao.ZdjeciaDaniaByName(name)) {
            result.add(new GaleriaDanDTO(e));
        }
        return result;
    }
}