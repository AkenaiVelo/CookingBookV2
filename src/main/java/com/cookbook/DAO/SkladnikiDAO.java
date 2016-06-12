package com.cookbook.DAO;

import com.cookbook.ENGINE.EngineDanie;
import com.cookbook.ENGINE.EngineSkladniki;
import com.cookbook.ENGINE.EngineSkladnikiDania;
import com.cookbook.Other.Loger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class SkladnikiDAO {

    @PersistenceContext
    private EntityManager em;
    @PersistenceUnit
    private EntityManagerFactory emf;

    public SkladnikiDAO() {
    }

    public List<EngineSkladniki> findAllSkladniki() {
        List<EngineSkladniki> all2;
        Query query = em.createQuery("SELECT p FROM EngineSkladniki p ");
        all2 = query.getResultList();
        return all2;
    }

    public int getIlosc(int idDania, String nazwaSkladnika) {
        Query query = em.createQuery("SELECT p FROM EngineSkladnikiDania p WHERE p.idDania.idDania = :param1 AND p.nazwaSkladnika.nazwa LIKE :param2")
                .setParameter("param1", idDania).setParameter("param2", nazwaSkladnika);
        List<EngineSkladnikiDania> all2;
        all2 = query.getResultList();
        return all2.get(0).getIlosc();
    }

    public int getIloscbyName(String nazwaDania, String nazwaSkladnika) {
        Query query = em.createQuery("SELECT p FROM EngineSkladnikiDania p WHERE p.idDania.nazwa LIKE :param1 AND p.nazwaSkladnika.nazwa LIKE :param2")
                .setParameter("param1", nazwaDania).setParameter("param2", nazwaSkladnika);
        List<EngineSkladnikiDania> all2;
        all2 = query.getResultList();
        return all2.get(0).getIlosc();
    }

    public List<EngineSkladniki> findAllIngredientsOfMeal(String name) {
        Query query = em.createQuery("SELECT p FROM EngineDanie p WHERE p.nazwa = :param1 ")
                .setParameter("param1", name);
        List<EngineDanie> danie = query.getResultList();

        //System.out.println("SkladnikiDAO danie="+danie.get(0).getNazwa());
        List<EngineSkladnikiDania> listaSkladnikow;
        listaSkladnikow = danie.get(0).getSkladnikiDania();

        System.out.println("SkladnikiDAO listaskladnikow ma rozmiar "+listaSkladnikow.size());
        List<EngineSkladniki> result = new ArrayList<>();
        int licznik = 0;
        for (EngineSkladnikiDania lista : listaSkladnikow) {
            licznik++;
            System.out.println("SkladnikiDAO dodaje skladnik "+lista.getNazwaSkladnika());
            //if (licznik % 2 == 0) {
                result.add(lista.getNazwaSkladnika());
            //}
        }
        return result;
    }
    
    public List<EngineSkladniki> findAllIngredientsOfMeal2(String name) {
        Query query = em.createQuery("SELECT p FROM EngineSkladnikiDania p WHERE p.idDania.nazwa = :param1 ")
                .setParameter("param1", name);
        List<EngineSkladnikiDania> danie = query.getResultList();

        //System.out.println("SkladnikiDAO danie="+danie.get(0).getNazwa());
       

        System.out.println("SkladnikiDAO listaskladnikow ma rozmiar "+danie.size());
        List<EngineSkladniki> result = new ArrayList<>();
        int licznik = 0;
        for (EngineSkladnikiDania lista : danie) {
            licznik++;
            System.out.println("SkladnikiDAO dodaje skladnik "+lista.getNazwaSkladnika());
            //if (licznik % 2 == 0) {
                result.add(lista.getNazwaSkladnika());
            //}
        }
        return result;
    }

    @Transactional
    public void deleteSkladnikByName(String nazwa) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query queryPomocnicze = em.createQuery("DELETE FROM EngineSkladnikiDania e WHERE e.nazwaSkladnika.nazwa LIKE :param1");
        int deletedCount = queryPomocnicze.setParameter("param1", nazwa).executeUpdate();
        System.out.println("Ilosc usunietych z tabeli posredniej to :" + deletedCount);
        Query query = em.createQuery("DELETE FROM EngineSkladniki e WHERE e.nazwa LIKE :param1");
        deletedCount = query.setParameter("param1", nazwa).executeUpdate();
        System.out.println("Ilosc usunietych to :" + deletedCount);
        em.flush();
        em.getTransaction().commit();
        
    }
    
    public EngineSkladniki findSkladnikByName(String nazwa)
    {
        Query query = em.createQuery("SELECT p FROM EngineSkladniki p WHERE p.nazwa Like :param1 ")
                .setParameter("param1", nazwa);
        List<EngineSkladniki> all2;
        all2 = query.getResultList();
        return all2.get(0);
    }
    
    public void addSkladnik(EngineSkladniki e)
    {
        EntityManager em=emf.createEntityManager();
        try {
            System.out.println("Zapisuje skladnik "+e);
            em.getTransaction().begin();
            em.persist(e);
            em.flush();
            em.getTransaction().commit();
        } catch (PersistenceException p) {
            System.out.println(p);
            Loger.logger.error("Błąd dodawania konta");
        }  
    }
    
     public void updateSkladnik(EngineSkladniki e,String nazwa)
    {
        EntityManager em=emf.createEntityManager();
        try {
            EngineSkladniki cel=em.find(EngineSkladniki.class, e.getNazwa());
            
            System.out.println("update skladnik "+e);
            em.getTransaction().begin();
            cel.setNazwa(e.getNazwa());
            cel.setOpis(e.getOpis());
            cel.setJednostka(e.getJednostka());
            cel.setZdjecie("skladniki/"+e.getNazwa()+".jpg");
            //em.flush();
            em.getTransaction().commit();
        } catch (PersistenceException p) {
            System.out.println(p);
            Loger.logger.error("Błąd dodawania konta");
        }  
    }
     
     public int czyNazwaSkladnikaWolna(String nazwa)
     {
          Query query = em.createQuery("SELECT p FROM EngineSkladniki p WHERE p.nazwa Like :param1 ")
                .setParameter("param1", nazwa);
        List<EngineSkladniki> all2;
        all2 = query.getResultList();
         return all2.size();
     }

}
