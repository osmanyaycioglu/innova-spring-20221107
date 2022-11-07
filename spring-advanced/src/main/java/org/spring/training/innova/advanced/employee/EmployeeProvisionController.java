package org.spring.training.innova.advanced.employee;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/employee/provision")
public class EmployeeProvisionController {

    @PostMapping("/add")
    @Operation(summary = "çalışan ekleme",description = "uzun zun yazıyorum deneme")
    public String add(@Valid @RequestBody EmployeeRest employeeRest){
        if (employeeRest.getName() == null){
            throw new IllegalArgumentException("name null olamaz");
        }
        return "OK";
    }

}
