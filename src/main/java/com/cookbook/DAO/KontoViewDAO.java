package com.cookbook.DAO;

import com.cookbook.ENGINE.EngineKonto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.springframework.stereotype.Component;


@Component
public class KontoViewDAO {

    @PersistenceContext
    private EntityManager em;

    public KontoViewDAO() {
    }

    public List<EngineKonto> findAllAccounts() {
        List<EngineKonto> all2 = new ArrayList<>();
        Query query = em.createQuery("SELECT p FROM EngineKonto p");
        all2 = query.getResultList();
        return all2;
    }

    public boolean checkAccountByLogin(String s)//sprawdza czy istnieje konto o podanym loginie
    {

        try {
            EngineKonto a = em.find(EngineKonto.class, s);
            if (a != null) {
                return true;
            } else {
                return false;
            }
        } catch (PersistenceException p) {
            return false;
        }
    }
    
    public EngineKonto getAccountByLogin(String login)
    {
        return em.find(EngineKonto.class, login);
    }
    
   
}
