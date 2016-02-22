
package com.cookbook.DAO;

import com.cookbook.ENGINE.EngineKonto;
import com.cookbook.Other.Loger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;

@Component
public class KontoChangeDAO {

    @PersistenceUnit
    private EntityManagerFactory emf;
    
    

    public KontoChangeDAO()
    {
        
    }
    @Transactional()
     public boolean AddAccount(EngineKonto account) {
        EntityManager em=emf.createEntityManager();
        try {
            System.out.println("Zapisuje "+account);
            em.getTransaction().begin();
            em.persist(account);
            em.flush();
            em.getTransaction().commit();
        } catch (PersistenceException p) {
            System.out.println(p);
            Loger.logger.error("Błąd dodawania konta");
            return false;
        }
        return true;
    }
    
    public boolean ChangePassword(EngineKonto ea, String noew_haslo)
    {
        EntityManager em=emf.createEntityManager();
        if(ea.getHaslo().equals(noew_haslo))
        {
              try {
          ea.setHaslo(noew_haslo);
            em.persist(ea);
        } catch (PersistenceException p) {
           Loger.logger.error("Nie udalo sie zmienic hasla!");
            return false;
        }
        return true;
        }
        else return false;   // hasla sie nie zgadzaja
    }
}