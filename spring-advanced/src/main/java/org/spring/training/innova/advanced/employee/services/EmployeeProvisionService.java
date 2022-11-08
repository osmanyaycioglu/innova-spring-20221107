package org.spring.training.innova.advanced.employee.services;

import org.spring.training.innova.advanced.employee.data.daos.EmployeeDataService;
import org.spring.training.innova.advanced.employee.services.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeProvisionService {

    @Autowired
    private EmployeeDataService employeeDataService;

    public void add(Employee toEmployee) {
        // işlem
        employeeDataService.insert(toEmployee);
    }
}
