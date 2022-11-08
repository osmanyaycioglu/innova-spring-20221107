package com.training.spring.advanced.rest;

import com.training.spring.advanced.customer.services.CustomerDataQueryService;
import com.training.spring.advanced.rest.mappers.ICustomerMapper;
import com.training.spring.advanced.rest.models.CustomerRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer/data/query")
public class CustomerDataQueryController {

    @Autowired
    private CustomerDataQueryService customerDataService;

    @GetMapping("/get/one")
    public CustomerRest getOneCustomer(@RequestParam("cid") Long customerId) {
        return ICustomerMapper.MAPPER.toCustomerRest(customerDataService.getOneCustomer(customerId));
    }

    @GetMapping("/get/all")
    public List<CustomerRest> getAllCustomers() {
        return ICustomerMapper.MAPPER.toCustomerRestList(customerDataService.getAllCustomers());
    }

    @GetMapping("/get/by/surname")
    public List<CustomerRest> getCustomersBySurname(@RequestParam("surnamae") String surname) {
        return ICustomerMapper.MAPPER.toCustomerRestList(customerDataService.getCustomersBySurname(surname));
    }

}
