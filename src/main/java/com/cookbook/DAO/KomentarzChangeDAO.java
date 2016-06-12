package com.cookbook.DAO;

import com.cookbook.ENGINE.EngineKomentarz;
import com.cookbook.Other.Loger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class KomentarzChangeDAO {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Transactional()
    public boolean addKomentarz(EngineKomentarz komentarz) {
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("Zapisuje " + komentarz);
            em.getTransaction().begin();
            em.persist(komentarz);
            em.flush();
            em.getTransaction().commit();
        } catch (PersistenceException p) {
            System.out.println(p);
            Loger.logger.error("Błąd dodawania kmoentarza");
            return false;
        }
        return true;
    }

    @Transactional()
    public boolean updateKomentarz(String id, String tresc) {
        EntityManager em = emf.createEntityManager();
        EngineKomentarz komentarz = em.find(EngineKomentarz.class, Integer.parseInt(id));
        komentarz.setOpis(tresc);
        try {
            System.out.println("update komentarza: " + komentarz);
            em.getTransaction().begin();
            em.persist(komentarz);
            em.flush();
            em.getTransaction().commit();
        } catch (PersistenceException p) {
            System.out.println(p);
            Loger.logger.error("Błąd dodawania kmoentarza");
            return false;
        }
        return true;
    }
}
