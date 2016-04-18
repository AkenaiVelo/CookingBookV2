package com.cookbook.Service;

import com.cookbook.DAO.DanieDAO;
import com.cookbook.DTO.DanieDTO;
import com.cookbook.ENGINE.EngineDanie;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DanieService {

    @Autowired
    DanieDAO danie_dao;

    public DanieService() {
    }

    public ArrayList<DanieDTO> findAllDaniaByLogin(String login) {
        ArrayList<DanieDTO> result = new ArrayList<>();
        for (EngineDanie e : danie_dao.findAllDaniaByLogin(login)) {
            result.add(new DanieDTO(e));
        }
        return result;
    }
    
    public ArrayList<DanieDTO> findAllDaniaByKategoria(String kategoria) {
        ArrayList<DanieDTO> result = new ArrayList<>();
        for (EngineDanie e : danie_dao.findAllDaniaByKategoria(kategoria)) {
            result.add(new DanieDTO(e));
        }
        return result;
    }

}
