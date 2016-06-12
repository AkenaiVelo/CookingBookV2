package com.cookbook.Service;

import com.cookbook.DAO.DanieDAO;
import com.cookbook.DAO.KomentarzChangeDAO;
import com.cookbook.DAO.KomentarzViewDAO;
import com.cookbook.DAO.KontoViewDAO;
import com.cookbook.DTO.KomentarzDTO;
import com.cookbook.ENGINE.EngineDanie;
import com.cookbook.ENGINE.EngineKomentarz;
import com.cookbook.ENGINE.EngineKonto;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KomentarzService {
    
    @Autowired
    KomentarzViewDAO komentarz_view_dao;
    @Autowired
    KomentarzChangeDAO komentarz_change_dao;
    @Autowired
    KontoViewDAO konto_dao;
    @Autowired
    DanieDAO danie_dao;

    public KomentarzService() {
    }
    
    public ArrayList<KomentarzDTO> getUserCommentsList(String login) {
        ArrayList<KomentarzDTO> result = new ArrayList<>();
        for (EngineKomentarz e : komentarz_view_dao.findAllCommentsByLogin(login)) {
            result.add(new KomentarzDTO(e));
        }
        return result;
    }
    
    public ArrayList<KomentarzDTO> getDanieCommentsList(String nazwa) {
        ArrayList<KomentarzDTO> result = new ArrayList<>();
        for (EngineKomentarz e : komentarz_view_dao.findAllCommentsByDanie(nazwa)) {
            result.add(new KomentarzDTO(e,e.getAutor().getLogin(),nazwa));
            System.out.println();
        }
        return result;
    }
    
    public boolean addKomentarz(KomentarzDTO k)
    {
        EngineKonto konto=konto_dao.getAccountByLogin(k.getAutor());
        EngineDanie danie=danie_dao.findDanieByName(k.getDanie());
        return komentarz_change_dao.addKomentarz(new EngineKomentarz(k.getDataWystawienia(), k.getOpis(), konto,danie));
    }
    
    public boolean updateKomentarz(String id,String tresc)
    {
        return komentarz_change_dao.updateKomentarz(id, tresc);
    }
    
}
