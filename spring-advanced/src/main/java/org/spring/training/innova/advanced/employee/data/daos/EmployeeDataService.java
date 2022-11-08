package org.spring.training.innova.advanced.employee.data.daos;

import org.spring.training.innova.advanced.employee.services.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDataService {

    @Autowired
    private IEmployeeDao employeeDao;

    public void insert(Employee employee){
        employeeDao.save(employee);
    }

    public void update(Employee employee){
        employeeDao.save(employee);
    }

}
