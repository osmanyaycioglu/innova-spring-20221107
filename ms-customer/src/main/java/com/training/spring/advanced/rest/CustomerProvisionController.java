package com.training.spring.advanced.rest;

import com.training.spring.advanced.customer.services.CustomerProvisionService;
import com.training.spring.advanced.rest.mappers.ICustomerMapper;
import com.training.spring.advanced.rest.models.CustomerRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customer/provision")
public class CustomerProvisionController {

    @Autowired
    private CustomerProvisionService customerProvisionService;

    @PostMapping("/add")
    public String add(@Valid @RequestBody CustomerRest customerRest) {
        customerProvisionService.addCustomer(ICustomerMapper.MAPPER.toCustomer(customerRest));
        return "OK";
    }

    @GetMapping("/disable")
    public String disable(@RequestParam("cid") Long customerId) {
        customerProvisionService.disable(customerId);
        return "OK";
    }

    @GetMapping("/enable")
    public String enable(@RequestParam("cid") Long customerId) {
        customerProvisionService.enable(customerId);
        return "OK";
    }


}
