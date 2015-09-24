package com.cookbook.DAO;

import com.cookbook.ENGINE.EngineAddress;
import com.cookbook.ENGINE.EnginePersons;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.PersistenceUnit;
import org.springframework.stereotype.Component;

@Component
public class AddressChangeDAO {

    @PersistenceUnit
    private EntityManagerFactory emf;

    public AddressChangeDAO() {
    }

    public boolean AddAddressToPerson(EnginePersons person, ArrayList<EngineAddress> address) {
        EntityManager em=emf.createEntityManager();
        try {
            person.setAddressList(address);
            em.getTransaction().begin();
            em.persist(person);
            em.flush();
            em.getTransaction().commit();
        } catch (PersistenceException p) {
            //log4j.error(blablabla+p);
            return false;
        }
        return true;
    }
}
