package com.cookbook.DTO;

import com.cookbook.ENGINE.EnginePersons;

public class PersonDTO {
    private Integer personId;
    private String firstname;
    private String surname;

    public PersonDTO(EnginePersons e) {
        personId=e.getPersonId();
        firstname=e.getFirstname();
        surname=e.getSurname();
    }

    public PersonDTO() {
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
     public String toString() {
        return "FirstName= " + firstname + " Surname= " + surname;
    }
}
