package org.spring.training.innova.advanced.employee.services.models;

import org.spring.training.innova.advanced.employee.services.EEmployeeStatus;
import org.spring.training.innova.advanced.jpa.PasswordConverter;
import org.spring.training.innova.advanced.security.JasyptSec;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
//@Table(name = "empolyee_info")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long            employeeId;
    private String          name;
    private String          surname;
    // @Column(name = "soy")
    @Convert(converter = PasswordConverter.class)
    private String          username;
    @Convert(converter = PasswordConverter.class)
    private String          activation;
    private Integer         height;
    private Integer         weight;
    private LocalDate       birthday;
    @Enumerated(EnumType.STRING)
    private EEmployeeStatus employeeStatus = EEmployeeStatus.ACTIVE;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address         address;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Phone>      phones;

//    @PreUpdate
//    @PrePersist
    public void beforeInsertUpdate() {
        username = JasyptSec.defaultEnc.encrypt(username);
        activation = JasyptSec.defaultEnc.encrypt(activation);
    }

//    @PostUpdate
//    @PostPersist
//    @PostLoad
    public void afterInsertUpdate() {
        username = JasyptSec.defaultEnc.decrypt(username);
        activation = JasyptSec.defaultEnc.decrypt(activation);
    }


    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getUsername() {
        return this.username;
    }

    public String getActivation() {
        return this.activation;
    }

    public Integer getHeight() {
        return this.height;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public EEmployeeStatus getEmployeeStatus() {
        return this.employeeStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setActivation(String activation) {
        this.activation = activation;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setEmployeeStatus(EEmployeeStatus employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }
}
