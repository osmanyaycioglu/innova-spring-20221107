package org.spring.training.innova.advanced.employee.rest.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class AddressRest {

    @NotEmpty
    private String city;
    @NotEmpty
    private String street;

}
