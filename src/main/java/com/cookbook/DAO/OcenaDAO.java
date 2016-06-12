package com.cookbook.DAO;

import com.cookbook.ENGINE.EngineDanie;
import com.cookbook.ENGINE.EngineKonto;
import com.cookbook.ENGINE.EngineOcena;
import com.cookbook.Other.Loger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OcenaDAO {
    @PersistenceContext
    private EntityManager em;
    @PersistenceUnit
    private EntityManagerFactory emf;
    @Autowired
    KontoViewDAO kontoDAO;
    @Autowired
    DanieDAO danieDAO;
    
     public List<EngineOcena> findAllOceny() {
        List<EngineOcena> all2 ;
        Query query = em.createQuery("SELECT p FROM EngineOcena p ");
        all2 = query.getResultList();
        return all2;
    }
     
     public int iloscOcen(String login,String nazwa)
     {
         List<EngineOcena> all2 ;
        Query query = em.createQuery("SELECT p FROM EngineOcena p WHERE p.login.login Like :par1 and p.idDania.nazwa like :par2")
                .setParameter("par1", login).setParameter("par2", nazwa);
        all2 = query.getResultList();
        return all2.size();
     }
     
     public void addOcena(String login,String nazwa,int ocena)
     {
         EngineKonto k=kontoDAO.getAccountByLogin(login);
         EngineDanie d=danieDAO.findDanieByName(nazwa);
         EngineOcena o=new EngineOcena(k, d, ocena);
         EntityManager eml=emf.createEntityManager();
        try {
            System.out.println("Zapisuje "+o);
            eml.getTransaction().begin();
            eml.persist(o);
            eml.flush();
            eml.getTransaction().commit();
        } catch (PersistenceException p) {
            System.out.println(p);
            Loger.logger.error("Błąd dodawania oceny");
        }
     }
     
     public int sumaOcenDania(String nazwaDania)
     {
         List<EngineOcena> all2 ;
        Query query = em.createQuery("SELECT p FROM EngineOcena p WHERE  p.idDania.nazwa like :par2")
                .setParameter("par2", nazwaDania);
        all2 = query.getResultList();
        int wynik=0;
        for(EngineOcena o:all2)
        {
            wynik+=o.getOcena();
        }
        return wynik;
     }
     
     public int sumaOcenpozytywnychDania(String nazwaDania)
     {
         List<EngineOcena> all2 ;
        Query query = em.createQuery("SELECT p FROM EngineOcena p WHERE  p.idDania.nazwa like :par2 and p.ocena=1")
                .setParameter("par2", nazwaDania);
        all2 = query.getResultList();
        int wynik=0;
        for(EngineOcena o:all2)
        {
            wynik+=o.getOcena();
        }
        return wynik;
     }
     
     public int sumaOcenNegatywnychDania(String nazwaDania)
     {
         List<EngineOcena> all2 ;
        Query query = em.createQuery("SELECT p FROM EngineOcena p WHERE  p.idDania.nazwa like :par2 and p.ocena=-1")
                .setParameter("par2", nazwaDania);
        all2 = query.getResultList();
        int wynik=0;
        for(EngineOcena o:all2)
        {
            wynik+=o.getOcena();
        }
        return wynik;
     }
    
}
