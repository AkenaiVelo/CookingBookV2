package com.cookbook.DAO;

import com.cookbook.ENGINE.EngineGaleriaDan;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;

@Component
public class GaleriaDanDAO {
    @PersistenceContext
    private EntityManager em;

    public GaleriaDanDAO() {
    }
    
    public List<EngineGaleriaDan> ZdjeciaDania(int idDania) {
        List<EngineGaleriaDan> all2 ;
        Query query = em.createQuery("SELECT g FROM EngineGaleriaDan g WHERE g.idDania.idDania = :param1 Order by g.numer")
                .setParameter("param1",idDania);
        all2 = query.getResultList();
        return all2;
    }
    
    public List<EngineGaleriaDan> ZdjeciaDaniaByName(String name) {
        List<EngineGaleriaDan> all2 ;
        Query query = em.createQuery("SELECT g FROM EngineGaleriaDan g WHERE g.idDania.nazwa LIKE :param1 Order by g.numer")
                .setParameter("param1",name);
        all2 = query.getResultList();
        return all2;
    }
}
