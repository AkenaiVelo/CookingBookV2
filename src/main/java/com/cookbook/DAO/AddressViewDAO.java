package com.cookbook.DAO;

import com.cookbook.ENGINE.EngineAddress;
import com.cookbook.ENGINE.EnginePersons;
import java.util.List;
import javax.persistence.*;
import org.springframework.stereotype.Component;

@Component
public class AddressViewDAO {

    @PersistenceContext
    private EntityManager em;

    public AddressViewDAO() {
    }

    public List<EngineAddress> CRITERIA_getAddressOfPerson(int person_id) {
        EnginePersons p = em.find(EnginePersons.class, person_id);
        return p.getAddressList();
    }

    public List<EngineAddress> HQL_getAddressOfPerson(int person_id) {
        List<EngineAddress> addressesOfPerson;
        Query query = em.createQuery("SELECT p FROM EngineAddress a WHERE p.personId='" + Integer.toString(person_id) + "'");
        addressesOfPerson = query.getResultList(); 
        return addressesOfPerson;
    }
}