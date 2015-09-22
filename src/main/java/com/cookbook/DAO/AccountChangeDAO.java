
package com.cookbook.DAO;

import com.cookbook.ENGINE.EngineAccount;
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
public class AccountChangeDAO {

    @PersistenceUnit
    private EntityManagerFactory emf;
    
    

    public AccountChangeDAO()
    {
        
    }
    @Transactional()
     public boolean AddAccount(EngineAccount account) {
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
    
    public boolean ChangePassword(EngineAccount ea, String new_password)
    {
        EntityManager em=emf.createEntityManager();
        if(ea.getPassword().equals(new_password))
        {
              try {
          ea.setPassword(new_password);
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