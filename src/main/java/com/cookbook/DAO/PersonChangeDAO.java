package com.cookbook.DAO;

import org.springframework.stereotype.Component;
import com.cookbook.ENGINE.EnginePersons;
import com.cookbook.Other.Loger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

@Component
public class PersonChangeDAO {

   @PersistenceUnit
    private EntityManagerFactory emf;

    public boolean AddPerson(EnginePersons person) {
              EntityManager em=emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.flush();
            em.getTransaction().commit();
        } catch (PersistenceException p) {
            Loger.logger.error("Błąd dodawania osoby");
            return false;
        }
        return true;
    }

    public boolean updatePersonFirstname(EnginePersons p, String newName) {
        EntityManager em=emf.createEntityManager();
        String hqlUpdate = "update EnginePersons c set c.firstname = :newName where c.personId = :id";
        Query x = em.createQuery(hqlUpdate)
                .setParameter("newName", newName)
                .setParameter("id", p.getPersonId());
        int result = x.executeUpdate();
        return result == 1;
    }

    public boolean deletePerson(EnginePersons p) {
       EntityManager em=emf.createEntityManager();
        String hqlDelete = "delete EnginePersons where id = :parId";
        int deletedEntities;
        deletedEntities = em.createQuery(hqlDelete)
                .setParameter("parId", p.getPersonId())
                .executeUpdate();
        return deletedEntities == 1;
    }
}