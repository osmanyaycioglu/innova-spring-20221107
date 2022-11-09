package org.spring.training.innova.advanced.employee.services;

import org.spring.training.innova.advanced.employee.data.daos.EmployeeDataService;
import org.spring.training.innova.advanced.employee.services.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeQueryService {

    @Autowired
    private EmployeeDataService dataService;

    public Employee getOne(Long empId) {
        return dataService.getOne(empId);
    }

    public List<Employee> getAll() {
        return dataService.getAll();
    }

    public List<Employee> getBySurname(String surname) {
        return dataService.getBySurname(surname);
    }
}
