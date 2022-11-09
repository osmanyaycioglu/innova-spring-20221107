package org.spring.training.innova.advanced.employee.rest;

import io.swagger.v3.oas.annotations.Operation;
import org.spring.training.innova.advanced.employee.rest.mappers.IEmployeeMapper;
import org.spring.training.innova.advanced.employee.rest.models.EmployeeRest;
import org.spring.training.innova.advanced.employee.services.EmployeeProvisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/employee/provision")
public class EmployeeProvisionController {

    @Autowired
    private EmployeeProvisionService eps;

    @PostMapping("/add")
    @Operation(summary = "çalışan ekleme",description = "uzun zun yazıyorum deneme")
    public String add(@Valid @RequestBody EmployeeRest employeeRest){
        if (employeeRest.getName() == null){
            throw new IllegalArgumentException("name null olamaz");
        }
        eps.add(IEmployeeMapper.mapper.toEmployee(employeeRest));
        return "OK";
    }

}
