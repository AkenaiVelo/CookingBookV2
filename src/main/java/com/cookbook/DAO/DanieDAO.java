package com.cookbook.DAO;

import com.cookbook.ENGINE.EngineDanie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;

@Component
public class DanieDAO {
    @PersistenceContext
    private EntityManager em;

    public DanieDAO() {
    }
    
    public List<EngineDanie> findAllDaniaByLogin(String login) {
        List<EngineDanie> all2 ;
        Query query = em.createQuery("SELECT p FROM EngineDanie p WHERE p.autor.login LIKE :param1")
                .setParameter("param1",login);
        all2 = query.getResultList();
        return all2;
    }
    
    public List<EngineDanie> findAllDaniaByKategoria(String kategoria) {
        List<EngineDanie> all2 ;
        Query query = em.createQuery("SELECT p FROM EngineDanie p WHERE p.kategoria.nazwa LIKE :param1")
                .setParameter("param1",kategoria);
        all2 = query.getResultList();
        return all2;
    }
    
    public EngineDanie findDanieByName(String name)
    {
        System.out.println("SELECT p FROM EngineDanie p WHERE p.nazwa LIKE "+name);
        Query query = em.createQuery("SELECT p FROM EngineDanie p WHERE p.nazwa LIKE :param1")
                .setParameter("param1",name);
        return (EngineDanie)query.getResultList().get(0);
    }
    
    public List<EngineDanie> findAllDania() {
        List<EngineDanie> all2 ;
        Query query = em.createQuery("SELECT d FROM EngineDanie d");
        all2 = query.getResultList();
        return all2;
    }
    
}
