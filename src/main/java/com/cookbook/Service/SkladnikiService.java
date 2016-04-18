package com.cookbook.Service;

import com.cookbook.DAO.SkladnikiDAO;
import com.cookbook.DTO.SkladnikiDTO;
import com.cookbook.ENGINE.EngineSkladniki;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkladnikiService {
    @Autowired
    SkladnikiDAO skladniki_dao;

    public SkladnikiService() {
    }
    
    public ArrayList<SkladnikiDTO> findAllSkladniki() {
        ArrayList<SkladnikiDTO> result = new ArrayList<>();
        for (EngineSkladniki e : skladniki_dao.findAllSkladniki()) {
            result.add(new SkladnikiDTO(e));
        }
        return result;
    }
    
    public int getilosc(int idDania,String nazwaSkladnika)
    {
        return skladniki_dao.getIlosc(idDania, nazwaSkladnika);
    }
}
