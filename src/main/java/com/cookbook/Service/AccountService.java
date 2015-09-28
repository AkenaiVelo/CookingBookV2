package com.cookbook.Service;

import com.cookbook.DAO.AccountChangeDAO;
import com.cookbook.DAO.AccountViewDAO;
import com.cookbook.DTO.AccountDTO;
import com.cookbook.ENGINE.EngineAccount;
import com.cookbook.Other.MD5Hash;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountChangeDAO account_change_dao;
    @Autowired
    private AccountViewDAO account_view_dao;

    public ArrayList<AccountDTO> getUsersList() {
        ArrayList<AccountDTO> result = new ArrayList<>();
        for (EngineAccount e : account_view_dao.findAllAccounts()) {
            result.add(new AccountDTO(e));
        }
        return result;
    }

    public boolean registerNewAccount(AccountDTO e) {
        EngineAccount tmp = new EngineAccount(e.getLogin(), e.getPassword());
        return account_change_dao.AddAccount(tmp);
    }

    public boolean checkLogin(String s)//sprawdza czy dany login jest zajety
    {
        return !account_view_dao.checkAccountByLogin(s);
    }

    public boolean CheckPassword(String login, String password) {
        EngineAccount temp = account_view_dao.getAccountByLogin(login);

        if (MD5Hash.getmd5(password).equals(temp.getPassword())) {
            return true;
        }
        return false;
    }
}
