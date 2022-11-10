package org.spring.training.innova.advanced.employee.rest;

import io.swagger.v3.oas.annotations.Operation;
import org.spring.training.innova.advanced.employee.rest.mappers.IEmployeeMapper;
import org.spring.training.innova.advanced.employee.rest.models.EmployeeRest;
import org.spring.training.innova.advanced.employee.services.EmployeeProvisionService;
import org.spring.training.innova.advanced.employee.services.EmployeeQueryService;
import org.spring.training.innova.advanced.employee.services.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee/query")
public class EmployeeQueryController {

    @Autowired
    private EmployeeQueryService eqs;

    @GetMapping("/get/one")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public EmployeeRest getOne(@RequestParam("empId") Long empId) {
        return IEmployeeMapper.mapper.toEmployeeRest(eqs.getOne(empId));
    }

    @GetMapping("/get/all")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public List<EmployeeRest> getAll() {
        return IEmployeeMapper.mapper.toEmployeeRests(eqs.getAll());
    }

    @GetMapping("/get/by/surname")
    @PreAuthorize("hasAnyRole('USER')")
    public List<EmployeeRest> getBySurname(@RequestParam("sur") String surname) {
        return IEmployeeMapper.mapper.toEmployeeRests(eqs.getBySurname(surname));
    }


}
