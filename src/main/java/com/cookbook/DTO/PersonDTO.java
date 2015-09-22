package com.cookbook.DTO;

import com.cookbook.ENGINE.EnginePersons;
import java.util.ArrayList;

public class PersonDTO {
    private Integer personId;
    private String firstname;
    private String surname;
    private ArrayList<String> addressList;

    public PersonDTO(EnginePersons e) {
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public ArrayList<String> getAddressList() {
        return addressList;
    }

    public void setAddressList(ArrayList<String> addressList) {
        this.addressList = addressList;
    }
}
