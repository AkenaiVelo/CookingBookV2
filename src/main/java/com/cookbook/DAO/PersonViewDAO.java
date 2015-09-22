package com.cookbook.DAO;

import com.cookbook.ENGINE.EnginePersons;
import com.cookbook.POJO.Persons;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.springframework.stereotype.Component;

@Component
public class PersonViewDAO {

    @PersistenceContext
    private EntityManager em;

    public PersonViewDAO() {
    }

    public EnginePersons getPersonById(int id) {
        EnginePersons p = em.find(EnginePersons.class, id);
        return p;
    }
    
    public List<EnginePersons> findAll() {
        List<Persons> all;
        List<EnginePersons> all2 = new ArrayList<>();
        Query query = em.createQuery("SELECT p FROM EnginePersons p"); 
        all2 = query.getResultList(); 
        return all2;
    }
}