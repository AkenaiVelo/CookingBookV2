package com.cookbook.Service;

import com.cookbook.DAO.KategoriaDanDAO;
import com.cookbook.DTO.KategoriaDanDTO;
import com.cookbook.ENGINE.EngineKategoriaDan;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KategoriaDanService {
    @Autowired
    KategoriaDanDAO kategoriaDanDAO; 

    public KategoriaDanService() {
    }
    
    public ArrayList<KategoriaDanDTO> findAllKategoriaDan() {
        ArrayList<KategoriaDanDTO> result = new ArrayList<>();
        for (EngineKategoriaDan e : kategoriaDanDAO.findAllKategoriaDan()) {
            result.add(new KategoriaDanDTO(e));
        }
        return result;
    }
}
