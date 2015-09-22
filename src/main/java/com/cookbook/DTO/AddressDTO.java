package com.cookbook.DTO;

import com.cookbook.ENGINE.EngineAddress;

public class AddressDTO {
    private Integer addressId;
    private String city;
    private String zipcode;
    private PersonDTO personId;

    public AddressDTO(EngineAddress a) { 
    }
    
    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public PersonDTO getPersonId() {
        return personId;
    }

    public void setPersonId(PersonDTO personId) {
        this.personId = personId;
    }
}