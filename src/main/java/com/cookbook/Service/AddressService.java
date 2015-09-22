package com.cookbook.Service;

import com.cookbook.DAO.AddressChangeDAO;
import com.cookbook.DAO.AddressViewDAO;
import com.cookbook.DTO.AddressDTO;
import com.cookbook.DTO.PersonDTO;
import com.cookbook.ENGINE.EngineAddress;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressViewDAO dao_view;
    @Autowired
    private AddressChangeDAO dao_change;
 
    public ArrayList<AddressDTO> getPersonAddress(PersonDTO p)
    {
        ArrayList<AddressDTO> result = new ArrayList<>();
        
        for(EngineAddress addr : dao_view.CRITERIA_getAddressOfPerson(p.getPersonId()))
        {
            result.add(new AddressDTO(addr));
        }
        return result;
    }
}