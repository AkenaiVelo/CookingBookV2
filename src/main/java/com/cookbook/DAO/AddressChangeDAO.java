package com.cookbook.DAO;

import com.cookbook.ENGINE.EngineAddress;
import com.cookbook.ENGINE.EnginePersons;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import org.springframework.stereotype.Component;

@Component
public class AddressChangeDAO {

    @PersistenceContext
    private EntityManager em;

    public AddressChangeDAO() {
    }

    public boolean AddAddressToPerson(EnginePersons person, ArrayList<EngineAddress> address) {
        try {
            person.setAddressList(address);
            em.persist(person);
        } catch (PersistenceException p) {
            //log4j.error(blablabla+p);
            return false;
        }
        return true;
    }
}
