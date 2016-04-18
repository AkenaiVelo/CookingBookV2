package com.cookbook.DAO;

import com.cookbook.ENGINE.EngineSkladniki;
import com.cookbook.ENGINE.EngineSkladnikiDania;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;

@Component
public class SkladnikiDAO {
    
    @PersistenceContext
    private EntityManager em;

    public SkladnikiDAO() {
    }
    
     public List<EngineSkladniki> findAllSkladniki() {
        List<EngineSkladniki> all2 ;
        Query query = em.createQuery("SELECT p FROM EngineSkladniki p ");
        all2 = query.getResultList();
        return all2;
    }
     
     public int getIlosc(int idDania,String nazwaSkladnika)
     {
        Query query = em.createQuery("SELECT p FROM EngineSkladnikiDania p WHERE p.idDania.idDania = :param1 AND p.nazwaSkladnika.nazwa LIKE :param2")
                .setParameter("param1",idDania).setParameter("param2", nazwaSkladnika);
        List<EngineSkladnikiDania> all2 ;
        all2 = query.getResultList();
        return all2.get(0).getIlosc();
     }
    
}
