package com.training.spring.advanced.customer.services.models;

public class CustomerDetails {

    private Long cdid;
    private String note;
    private String gender;
    private Long customerId;
    private Long counter; // 5  6 6 7
    private Long version; // 1  2 2 3

    public Long getCdid() {
        return cdid;
    }

    public void setCdid(Long cdid) {
        this.cdid = cdid;
    }

    public String getNote() {
        return note;
    }

    public CustomerDetails setNote(String note) {
        this.note = note;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public CustomerDetails setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public CustomerDetails setCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getCounter() {
        return counter;
    }

    public void setCounter(Long counter) {
        this.counter = counter;
    }
}
