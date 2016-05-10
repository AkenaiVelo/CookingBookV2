package com.cookbook.DAO;

import com.cookbook.ENGINE.EngineDanie;
import com.cookbook.ENGINE.EngineSkladniki;
import com.cookbook.ENGINE.EngineSkladnikiDania;
import java.util.ArrayList;
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
     
      public int getIloscbyName(String nazwaDania,String nazwaSkladnika)
     {
        Query query = em.createQuery("SELECT p FROM EngineSkladnikiDania p WHERE p.idDania.nazwa LIKE :param1 AND p.nazwaSkladnika.nazwa LIKE :param2")
                .setParameter("param1",nazwaDania).setParameter("param2", nazwaSkladnika);
        List<EngineSkladnikiDania> all2 ;
        all2 = query.getResultList();
        return all2.get(0).getIlosc();
     }
     
     public List<EngineSkladniki> findAllIngredientsOfMeal(String name) {
        Query query = em.createQuery("SELECT p FROM EngineDanie p WHERE p.nazwa = :param1 ")
                .setParameter("param1",name);
        List<EngineDanie> danie=query.getResultList();
        
        List<EngineSkladnikiDania> listaSkladnikow ;
        listaSkladnikow = danie.get(0).getSkladnikiDania();
        
        List<EngineSkladniki> result=new ArrayList<>();
        for(EngineSkladnikiDania lista:listaSkladnikow)
        {
            result.add(lista.getNazwaSkladnika());
        }
        return result;
    }
    
}
