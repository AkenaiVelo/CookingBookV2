package com.cookbook.DAO;

import com.cookbook.ENGINE.EngineKategoriaDan;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;

@Component
public class KategoriaDanDAO {
    @PersistenceContext
    private EntityManager em;

    public KategoriaDanDAO() {
    }
    
    
    
    public List<EngineKategoriaDan> findAllKategoriaDan() {
        List<EngineKategoriaDan> all2 ;
        Query query = em.createQuery("SELECT p FROM EngineKategoriaDan p");
        all2 = query.getResultList();
        return all2;
    }
}
