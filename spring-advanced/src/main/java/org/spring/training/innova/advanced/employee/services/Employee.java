package org.spring.training.innova.advanced.employee.services;

import java.time.LocalDate;

public class Employee {

    private String          name;
    private String          surname;
    private String          username;
    private String          activation;
    private Integer         height;
    private Integer         weight;
    private LocalDate       birthday;
    private EEmployeeStatus employeeStatus;

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
}
