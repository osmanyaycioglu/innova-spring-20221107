package com.training.spring.advanced.customer.services;

import com.training.spring.advanced.customer.services.models.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerProvisionService {

    public Long addCustomer(Customer customer) {
        return 1L;
    }

    public String enable(Long customerId) {
        return "OK";
    }

    public String disable(Long customerId) {
        return "OK";
    }

}
