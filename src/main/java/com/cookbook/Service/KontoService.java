package com.cookbook.Service;

import com.cookbook.DAO.KontoChangeDAO;
import com.cookbook.DAO.KontoViewDAO;
import com.cookbook.DTO.KontoDTO;
import com.cookbook.ENGINE.EngineKonto;
import com.cookbook.Other.MD5Hash;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KontoService {

    @Autowired
    private KontoChangeDAO account_change_dao;
    @Autowired
    private KontoViewDAO account_view_dao;

    public ArrayList<KontoDTO> getUsersList() {
        ArrayList<KontoDTO> result = new ArrayList<>();
        for (EngineKonto e : account_view_dao.findAllAccounts()) {
            result.add(new KontoDTO(e));
        }
        return result;
    }

    public boolean registerNewAccount(KontoDTO e) {
        EngineKonto tmp = new EngineKonto(e.getLogin(), e.getHaslo(),e.getEmail(),e.getPoziom());
        return account_change_dao.AddAccount(tmp);
    }

    public boolean checkLogin(String s)//sprawdza czy dany login jest zajety
    {
        return !account_view_dao.checkAccountByLogin(s);
    }
    public boolean isEmailValid(String s)
    {
        return account_view_dao.isEmailValid(s);
    }

    public boolean CheckPassword(String login, String password) {
        EngineKonto temp = account_view_dao.getAccountByLogin(login);

        if (MD5Hash.getmd5(password).equals(temp.getHaslo())) {
            return true;
        }
        return false;
    }
    
    public int getAcountLevel(String login)
    {
        EngineKonto e=account_view_dao.getAccountByLogin(login);
        return e.getPoziom();
    }
}
