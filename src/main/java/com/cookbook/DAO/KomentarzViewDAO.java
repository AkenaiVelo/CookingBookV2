package com.cookbook.DAO;

import com.cookbook.ENGINE.EngineKomentarz;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;

@Component
public class KomentarzViewDAO {
    @PersistenceContext
    private EntityManager em;

    public KomentarzViewDAO() {
    }
    
    public List<EngineKomentarz> findAllCommentsByLogin(String login) {
        List<EngineKomentarz> all2 ;
        Query query = em.createQuery("SELECT p FROM EngineKomentarz p WHERE p.autor.login LIKE :param1")
                .setParameter("param1",login);
        all2 = query.getResultList();
        return all2;
    }
    
    public List<EngineKomentarz> findAllCommentsByDanie(String nazwa) {
        List<EngineKomentarz> all2 ;
        Query query = em.createQuery("SELECT p FROM EngineKomentarz p WHERE p.idDania.nazwa LIKE :param1 ORDER BY p.idKomentarz")
                .setParameter("param1",nazwa);
        all2 = query.getResultList();
        return all2;
    }
}
