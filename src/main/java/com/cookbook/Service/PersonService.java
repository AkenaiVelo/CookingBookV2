package com.cookbook.Service;

import org.springframework.stereotype.Service;
import com.cookbook.DAO.*;
import com.cookbook.ENGINE.EnginePersons;
import com.cookbook.DTO.PersonDTO;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PersonService {

    @Autowired
    private PersonViewDAO bazaOut;
     @Autowired
    private PersonChangeDAO bazaIn;

    public ArrayList<PersonDTO> usersList() {
        ArrayList<PersonDTO> result = new ArrayList<>();
        for (EnginePersons e : bazaOut.findAll()) {
            result.add(new PersonDTO(e));
        }
        return result;
    }

    public boolean register(PersonDTO e) {
        return bazaIn.AddPerson(new EnginePersons(e));
    }
}
