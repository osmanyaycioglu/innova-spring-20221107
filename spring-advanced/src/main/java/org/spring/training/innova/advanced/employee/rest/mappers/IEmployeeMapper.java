package org.spring.training.innova.advanced.employee.rest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.spring.training.innova.advanced.employee.rest.EmployeeRest;
import org.spring.training.innova.advanced.employee.services.models.Employee;

//@Mapper
public interface IEmployeeMapper {

    IEmployeeMapper mapper = new IEmployeeMapperImpl();

    @Mappings({@Mapping(source = "password",target = "activation")})
    Employee toEmployee(EmployeeRest emp);

    @Mappings({@Mapping(source = "activation",target = "password")})
    EmployeeRest toEmployeeRest(Employee emp);

}
