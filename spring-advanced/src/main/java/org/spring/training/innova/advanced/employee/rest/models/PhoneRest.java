package org.spring.training.innova.advanced.employee.rest.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
public class PhoneRest {

    private String name;
    private String phoneNumber;

}
