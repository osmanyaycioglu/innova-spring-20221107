package com.training.spring.advanced.rest.models;

import javax.validation.constraints.NotEmpty;

public class AddressRest {
    @NotEmpty
    private String city;
    @NotEmpty
    private String street;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
