package com.cookbook.Service;

import com.cookbook.DAO.KomentarzViewDAO;
import com.cookbook.DTO.KomentarzDTO;
import com.cookbook.ENGINE.EngineKomentarz;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KomentarzService {
    
    @Autowired
    KomentarzViewDAO komentarz_view_dao;

    public KomentarzService() {
    }
    
    public ArrayList<KomentarzDTO> getUserCommentsList(String login) {
        ArrayList<KomentarzDTO> result = new ArrayList<>();
        for (EngineKomentarz e : komentarz_view_dao.findAllCommentsByLogin(login)) {
            result.add(new KomentarzDTO(e));
        }
        return result;
    }
    
}
