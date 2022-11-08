package org.spring.training.innova.advanced.employee.rest.mappers;

import org.spring.training.innova.advanced.employee.rest.EmployeeRest;
import org.spring.training.innova.advanced.employee.services.models.Employee;

import javax.annotation.processing.Generated;


public class IEmployeeMapperImpl implements IEmployeeMapper {

    @Override
    public Employee toEmployee(EmployeeRest emp) {
        if ( emp == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setActivation( emp.getPassword() );
        employee.setName( emp.getName() );
        employee.setSurname( emp.getSurname() );
        employee.setUsername( emp.getUsername() );
        employee.setHeight( emp.getHeight() );
        employee.setWeight( emp.getWeight() );
        employee.setBirthday( emp.getBirthday() );

        return employee;
    }

    @Override
    public EmployeeRest toEmployeeRest(Employee emp) {
        if ( emp == null ) {
            return null;
        }

        EmployeeRest employeeRest = new EmployeeRest();

        employeeRest.setPassword( emp.getActivation() );
        employeeRest.setName( emp.getName() );
        employeeRest.setSurname( emp.getSurname() );
        employeeRest.setUsername( emp.getUsername() );
        employeeRest.setHeight( emp.getHeight() );
        employeeRest.setWeight( emp.getWeight() );
        employeeRest.setBirthday( emp.getBirthday() );

        return employeeRest;
    }
}
