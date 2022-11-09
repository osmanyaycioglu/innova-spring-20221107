package org.spring.training.innova.advanced.employee.rest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.spring.training.innova.advanced.employee.rest.models.AddressRest;
import org.spring.training.innova.advanced.employee.rest.models.EmployeeRest;
import org.spring.training.innova.advanced.employee.rest.models.PhoneRest;
import org.spring.training.innova.advanced.employee.services.models.Address;
import org.spring.training.innova.advanced.employee.services.models.Employee;
import org.spring.training.innova.advanced.employee.services.models.Phone;

import java.util.Set;

@Mapper
public interface IEmployeeMapper {

    IEmployeeMapper mapper = Mappers.getMapper(IEmployeeMapper.class);

    @Mappings({@Mapping(source = "password",target = "activation")})
    Employee toEmployee(EmployeeRest emp);

    @Mappings({@Mapping(source = "activation",target = "password")})
    EmployeeRest toEmployeeRest(Employee emp);

    Address toAddress(AddressRest add);

    AddressRest toAddressRest(Address add);

    Phone toPhone(PhoneRest phoneRest);

    PhoneRest toPhoneRest(Phone phoneRest);

    Set<Phone> toPhones(Set<PhoneRest> phones);

    Set<PhoneRest> toPhonesRest(Set<Phone> phones);

}
