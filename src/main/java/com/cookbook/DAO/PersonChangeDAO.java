package com.cookbook.DAO;

import org.springframework.stereotype.Component;
import com.cookbook.ENGINE.EnginePersons;
import com.cookbook.Other.Loger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Component
public class PersonChangeDAO {

    @PersistenceContext
    private EntityManager em;

    public boolean AddPerson(EnginePersons person) {
        try {
            em.persist(person);
        } catch (PersistenceException p) {
            Loger.logger.error("Błąd dodawania osoby");
            return false;
        }
        return true;
    }

    public boolean updatePersonFirstname(EnginePersons p, String newName) {
        String hqlUpdate = "update EnginePersons c set c.firstname = :newName where c.personId = :id";
        Query x = em.createQuery(hqlUpdate)
                .setParameter("newName", newName)
                .setParameter("id", p.getPersonId());
        int result = x.executeUpdate();
        return result == 1;
    }

    public boolean deletePerson(EnginePersons p) {
        String hqlDelete = "delete EnginePersons where id = :parId";
        int deletedEntities;
        deletedEntities = em.createQuery(hqlDelete)
                .setParameter("parId", p.getPersonId())
                .executeUpdate();
        return deletedEntities == 1;
    }
}